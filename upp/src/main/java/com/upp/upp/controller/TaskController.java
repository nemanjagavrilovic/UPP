package com.upp.upp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.form.FormField;
import org.camunda.bpm.engine.form.TaskFormData;
import org.camunda.bpm.engine.impl.identity.Authentication;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.upp.upp.converter.TaskToTaskDtoConverter;
import com.upp.upp.lucene.Article;
import com.upp.upp.model.FormSubmissionDto;
import com.upp.upp.model.TaskDto;
import com.upp.upp.service.MagazineService;

@Controller
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private FormService formService;
	
	@Autowired
	private TaskToTaskDtoConverter taskToTaskDtoConverter;
	
	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private MagazineService magazineService;
	
	@RequestMapping(value = "/startProcess", method = RequestMethod.GET)
	private String  startProcess(HttpServletRequest request) {
		
		String user = (String) request.getSession().getAttribute("loggedUser");
		Authentication currentAuthentication = null;
		currentAuthentication = new Authentication(user,new ArrayList<String>());
		identityService.setAuthentication(currentAuthentication);

		ProcessInstance pi = runtimeService.startProcessInstanceByKey("Process_1");
		Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).list().get(0);
		TaskFormData tfd = formService.getTaskFormData(task.getId());
		List<FormField> properties = tfd.getFormFields();
		for (FormField fp : properties) {
			System.out.println(fp.getId() + fp.getType());
		}
		request.getSession().setAttribute("task", new TaskDto(task.getId(), task.getName(), task.getAssignee()));
		request.getSession().setAttribute("magazines", magazineService.findAll());
		return "redirect:/jsp/chooseMagazine.jsp";
	}
	@PostMapping(path = "/complete/{taskId}", produces = "application/json")
	public @ResponseBody ResponseEntity<List<TaskDto>> complete(@PathVariable String taskId) {
		Task taskTemp = taskService.createTaskQuery().taskId(taskId).singleResult();
		taskService.complete(taskId);
		List<Task> tasks = taskService.createTaskQuery().processInstanceId(taskTemp.getProcessInstanceId()).list();
		List<TaskDto> dtos = new ArrayList<TaskDto>();
		for (Task task : tasks) {
			TaskDto t = new TaskDto(task.getId(), task.getName(), task.getAssignee());
			dtos.add(t);
		}
		return new ResponseEntity<List<TaskDto>>(dtos, HttpStatus.OK);
	}

	@PostMapping(path = "/post/{taskId}/{form}", produces = "application/json")
	public @ResponseBody ResponseEntity post(@RequestBody List<FormSubmissionDto> dto, @PathVariable String taskId,
			@PathVariable("form") String form) {
		HashMap<String, Object> map = this.mapListToDto(dto);

		// list all running/unsuspended instances of the process

		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		String processInstanceId = task.getProcessInstanceId();
		runtimeService.setVariable(processInstanceId, form, dto);
		formService.submitTaskForm(taskId, map);
		List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstanceId).list();
		TaskDto taskDto = null;
		if(!tasks.isEmpty())
			taskDto = new TaskDto(tasks.get(0).getId(), tasks.get(0).getName(), tasks.get(0).getAssignee());
	    
		return new ResponseEntity<TaskDto>(taskDto,HttpStatus.OK);
	}
	
	@GetMapping(path = "/get", produces = "application/json")
    public @ResponseBody TaskDto get() {
		//provera da li korisnik sa id-jem pera postoji
		//List<User> users = identityService.createUserQuery().userId("pera").list();
		ProcessInstance processInstance =
		        runtimeService.createProcessInstanceQuery()
			            .processDefinitionKey("Process_1")
			            .active() // we only want the unsuspended process instances
			            .list().get(0);
			
		Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).list().get(0);
	
        return new TaskDto(task.getId(), task.getName(), task.getAssignee());
    }
	@RequestMapping(path = "/claim/{taskId}", produces = "application/json", method=RequestMethod.GET)
	public String  claim(@PathVariable ("taskId") String taskId,
			HttpServletRequest request) {
		String user = (String)request.getSession().getAttribute("loggedUser");
		Task task =  taskService.createTaskQuery().taskId(taskId).list().get(0);
		task.setAssignee(user);
		taskService.saveTask(task);
		return "redirect:/jsp/home.jsp";
		
	}
	//Get task
	@RequestMapping(path = "/{taskId}", produces = "application/json", method=RequestMethod.GET)
	public String  getTask(@PathVariable ("taskId") String taskId,
												HttpServletRequest request) {
		Task task =  taskService.createTaskQuery().taskId(taskId).list().get(0);
		TaskFormData tfd = formService.getTaskFormData(taskId);
		List<FormField> properties = tfd.getFormFields();
		for (FormField fp : properties) {
			System.out.println(fp.getId() + fp.getType());
		}
		Article article = (Article)runtimeService.getVariable(task.getProcessInstanceId(), "article");
		
		request.getSession().setAttribute("formFields", properties);
		request.getSession().setAttribute("task", new TaskDto(task.getId(), task.getName(), task.getAssignee()));
		request.getSession().setAttribute("article", article);
		
		if(task.getName().equals("Chief editor review")) {
			return "redirect:/jsp/editorReview.jsp";
		} else if(task.getName().equals("Author PDF rework")) {
			return "redirect:/jsp/rework.jsp";
		} else if(task.getName().equals("Choose reviewers")) {
			request.getSession().setAttribute("byDistance", runtimeService.getVariable(task.getProcessInstanceId(), "byDistance"));
			request.getSession().setAttribute("moreLikeThis", runtimeService.getVariable(task.getProcessInstanceId(), "moreLikeThis"));
			return "redirect:/jsp/chooseReviewer.jsp";
			
		} else if (task.getName().equals("Reviewing")) {
			return "redirect:/jsp/review.jsp";
		} else if (task.getName().equals("Rework with reviewers comments")) {
			return "redirect:/jsp/reworkWithReviewersComments.jsp";
		} else if (task.getName().equals("Review rating")) {
			return "redirect:/jsp/finalDecision.jsp";
		} else if (task.getName().equals("Choose magazine")) {
			return "redirect:/jsp/chooseMagazine.jsp";
		} else if (task.getName().equals("Add new article")) {
			return "redirect:/jsp/upload.jsp";
		} else if (task.getName().equals("Add coauthor")) {
			return "redirect:/jsp/addCoauthor.jsp";
		}
		return "redirect:/jsp/task.jsp";
	}
	//All user tasks
	@RequestMapping(path = "/tasks", produces = "application/json", method=RequestMethod.GET)
	public String getUserTasks(HttpServletRequest request) {
		String user = (String)request.getSession().getAttribute("loggedUser");
		if(user != null ) {
			List<Task> tasks = taskService.createTaskQuery().taskAssignee(user).list();
			List<Task> candidate = taskService.createTaskQuery().taskCandidateUser(user).list();
			request.getSession().setAttribute("tasks", taskToTaskDtoConverter.convertList(tasks));
			request.getSession().setAttribute("candidate", taskToTaskDtoConverter.convertList(candidate));
		}
		return "redirect:/jsp/home.jsp";
	}
	
	private HashMap<String, Object> mapListToDto(List<FormSubmissionDto> list) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		for (FormSubmissionDto temp : list) {
			map.put(temp.getFieldId(), temp.getFieldValue());
		}

		return map;
	}
}
