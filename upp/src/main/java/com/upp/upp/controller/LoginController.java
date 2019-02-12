package com.upp.upp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.form.FormField;
import org.camunda.bpm.engine.form.TaskFormData;
import org.camunda.bpm.engine.impl.context.Context;
import org.camunda.bpm.engine.impl.identity.Authentication;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	private IdentityService identityService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	private ResponseEntity<User> login (HttpServletRequest request, @RequestBody com.upp.upp.model.User user) {
		com.upp.upp.model.User loggedUser = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		Authentication currentAuthentication = null;
		
		if(loggedUser != null) {
			request.getSession().setAttribute("loggedUser", user.getUsername());
			currentAuthentication = new Authentication(user.getUsername(),new ArrayList<String>());
			identityService.setAuthentication(currentAuthentication);
			identityService.setAuthenticatedUserId(user.getUsername());
		}else {
			request.getSession().setAttribute("loggedUser", "");
			currentAuthentication = new Authentication("",new ArrayList<String>());
			identityService.setAuthentication(currentAuthentication);
		}
		return new ResponseEntity<User> (loggedUser, HttpStatus.OK);
	}
}
