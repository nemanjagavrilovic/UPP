package com.upp.upp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.impl.identity.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.upp.upp.model.CamundaUser;
import com.upp.upp.service.CamundaUserService;

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
	private CamundaUserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	private ResponseEntity<CamundaUser> login (HttpServletRequest request, @RequestBody CamundaUser user) {
		CamundaUser loggedUser = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
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
		return new ResponseEntity<CamundaUser> (loggedUser, HttpStatus.OK);
	}
}
