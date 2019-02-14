package com.upp.upp.controller;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBElement;

import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.form.FormField;
import org.camunda.bpm.engine.form.TaskFormData;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.upp.upp.converter.UploadModelToArticle;
import com.upp.upp.dto.OrderDTO;
import com.upp.upp.lucene.Article;
import com.upp.upp.lucene.UploadModel;
import com.upp.upp.model.FormSubmissionDto;
import com.upp.upp.model.TaskDto;
import com.upp.upp.requestAndresponse.ArticleSaveResponse;
import com.upp.upp.service.ArticleService;

@Controller
@RequestMapping(value="/articles")
public class ArticleController {

	@Autowired
	private ArticleService aricleService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UploadModelToArticle uploadModelToArticle;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private FormService formService;
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public ResponseEntity<Iterable<Article>> findAll(HttpServletRequest request) {
		return new ResponseEntity<Iterable<Article>>(aricleService.findAll(),HttpStatus.OK);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public String findOne(HttpServletRequest request,
											@PathVariable("id") Long id) {
		Optional<Article> article = aricleService.findOne(id);
		request.getSession().setAttribute("article", article.get());
		return "forward:/jsp/article.jsp";
	}
	@CrossOrigin
	@RequestMapping(value = "/createOrder/", method = RequestMethod.POST)
	public ResponseEntity<?> createOrder(HttpServletRequest request,@RequestBody OrderDTO order,HttpServletResponse httpServletResponse) {
		String url = restTemplate.postForObject("https://localhost:1234/koncentrator/order/create", order, String.class);
	    return new ResponseEntity<String>(url,HttpStatus.OK);
	}
	@RequestMapping(value="/save/{task}",method= RequestMethod.POST)
	public ResponseEntity<Article> save(HttpServletRequest request,
										@RequestBody UploadModel model,
										@PathVariable ("task") String taskId){
		Article article = uploadModelToArticle.convert(model);
		RestTemplate client = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		FormSubmissionDto title = new FormSubmissionDto("title",article.getTitle());
		FormSubmissionDto abstracts = new FormSubmissionDto("abstracts",article.getAbstracts());
		FormSubmissionDto filename = new FormSubmissionDto("filename",article.getFilename());
		
		List<FormSubmissionDto> list = new ArrayList<>();
		list.add(title);
		list.add(abstracts);
		list.add(filename);
		HttpEntity<List<FormSubmissionDto>> entity = new HttpEntity<List<FormSubmissionDto>>(list, headers);
		TaskDto response = client.postForObject("http://localhost:8081/task/post/"+taskId+"/addArticle", entity,
				TaskDto.class);
		Task task =  taskService.createTaskQuery().taskId(response.getTaskId()).list().get(0);
		TaskFormData tfd = formService.getTaskFormData(task.getId());
		List<FormField> properties = tfd.getFormFields();
		request.getSession().setAttribute("formFields", properties);
		request.getSession().setAttribute("task", new TaskDto(task.getId(), task.getName(), task.getAssignee()));
		
		try {
			String fileName = saveUploadedFile(article.getFile(),article.getFilename());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Article>(article,HttpStatus.OK);
	}
	private String saveUploadedFile(String file, String filename) throws IOException {
		String retVal = null;
		DataOutputStream os;
		try {
			byte[] bytes = Base64.getDecoder().decode(file);
			Path path = Paths.get("D:\\Fakultet\\6 semestar\\Web\\WEB-work\\UPP\\upp\\src\\main\\webapp\\data" + File.separator +filename);
	          
			os = new DataOutputStream(new FileOutputStream("D:\\Fakultet\\6 semestar\\Web\\WEB-work\\UPP\\upp\\src\\main\\webapp\\data"+File.separator+filename));
			os.write(bytes);
			os.close();
			retVal = path.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
}
