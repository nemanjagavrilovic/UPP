package com.upp.upp.controller;

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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.upp.upp.model.FormFieldsDto;
import com.upp.upp.model.User;
import com.upp.upp.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	TaskService taskService;

	@Autowired
	FormService formService;

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	private @ResponseBody FormFieldsDto loginPage(HttpServletRequest request) {
		ProcessInstance pi = runtimeService.startProcessInstanceByKey("Process_1");

		Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).list().get(0);

		TaskFormData tfd = formService.getTaskFormData(task.getId());
		List<FormField> properties = tfd.getFormFields();
		for (FormField fp : properties) {
			System.out.println(fp.getId() + fp.getType());
		}
		request.getSession().setAttribute("formFields", properties);
		return new FormFieldsDto(task.getId(), pi.getId(), properties);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	private ResponseEntity<User> login (HttpServletRequest request, @RequestBody User user) {
		User loggedUser = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(loggedUser != null) {
			request.getSession().setAttribute("loggedUser", user.getUsername());
		}else {
			request.getSession().setAttribute("loggedUser", "");
		}
		return new ResponseEntity<User> (loggedUser, HttpStatus.OK);
	}
}
