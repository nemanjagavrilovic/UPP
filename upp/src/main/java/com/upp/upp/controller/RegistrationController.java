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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.upp.upp.model.FormFieldsDto;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	TaskService taskService;

	@Autowired
	FormService formService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public @ResponseBody FormFieldsDto registration(HttpServletRequest request) {
		ProcessInstance pi = runtimeService.startProcessInstanceByKey("registration");

		Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).list().get(0);

		TaskFormData tfd = formService.getTaskFormData(task.getId());
		List<FormField> properties = tfd.getFormFields();
		for (FormField fp : properties) {
			System.out.println(fp.getId() + fp.getType());
		}
		request.getSession().setAttribute("formFields", properties);
		return new FormFieldsDto(task.getId(), pi.getId(), properties);
	}
}
