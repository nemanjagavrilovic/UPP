package com.upp.upp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.form.FormField;
import org.camunda.bpm.engine.form.TaskFormData;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.upp.upp.converter.TaskToTaskDtoConverter;
import com.upp.upp.model.FormSubmissionDto;
import com.upp.upp.model.TaskDto;
import com.upp.upp.model.User;

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
	
	@GetMapping(path = "/{taskId}", produces = "application/json")
	public String  getTask(@PathVariable ("taskId") String taskId,
												HttpServletRequest request) {
		Task task =  taskService.createTaskQuery().taskId(taskId).list().get(0);
		TaskFormData tfd = formService.getTaskFormData(taskId);
		List<FormField> properties = tfd.getFormFields();
		for (FormField fp : properties) {
			System.out.println(fp.getId() + fp.getType());
		}
		request.getSession().setAttribute("formFields", properties);
		return "redirect:/jsp/task.jsp";
	}
	
	@GetMapping(path = "/tasks", produces = "application/json")
	public String getUserTasks(HttpServletRequest request) {
		String user = (String)request.getSession().getAttribute("loggedUser");

		List<Task> tasks = taskService.createTaskQuery().taskAssignee(user).list();
		request.getSession().setAttribute("tasks", taskToTaskDtoConverter.convertList(tasks));
		
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
