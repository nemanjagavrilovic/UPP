package com.upp.upp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.form.FormField;
import org.camunda.bpm.engine.form.TaskFormData;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import com.upp.upp.model.FormSubmissionDto;
import com.upp.upp.model.TaskDto;
import com.upp.upp.service.MagazineService;

@Controller
@RequestMapping("/magazines")
public class MagazineController {

	@Autowired
	private MagazineService magazineService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private FormService formService;
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String getMagazines(HttpServletRequest request) {
		request.getSession().setAttribute("magazines", magazineService.findAll());
		return "redirect:/jsp/chooseMagazine.jsp";
	}
	@RequestMapping(value = "/chooseMagazine/{id}/{task}", method=RequestMethod.GET)
	public  RedirectView  chooseMagazine(HttpServletRequest request, @PathVariable ("id") Long id,@PathVariable ("task") String taskId) {
		RestTemplate client = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		FormSubmissionDto fsd = new FormSubmissionDto("chooseMagazine",id.toString());
		List<FormSubmissionDto> list = new ArrayList<>();
		list.add(fsd);
		HttpEntity<List<FormSubmissionDto>> entity = new HttpEntity<List<FormSubmissionDto>>(list, headers);
		TaskDto response = client.postForObject("http://localhost:9000/task/post/"+taskId+"/chooseMagazine", entity,
				TaskDto.class);
		Task task =  taskService.createTaskQuery().taskId(response.getTaskId()).list().get(0);
		TaskFormData tfd = formService.getTaskFormData(task.getId());
		List<FormField> properties = tfd.getFormFields();
		request.getSession().setAttribute("formFields", properties);
		return new RedirectView("/jsp/task.jsp");
	}
}
