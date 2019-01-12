package com.upp.upp.service;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;

import com.upp.upp.model.FormSubmissionDto;

public class CheckUserLogin implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		List<FormSubmissionDto> login = (List<FormSubmissionDto>)execution.getVariable("login");
	    System.out.println(login);
	    for(FormSubmissionDto dto : login ) {
	    	System.out.println(dto.getFieldId()+" "+dto.getFieldValue());
	    }
		System.out.println();
		execution.setVariable("loggedUser", "USER");
	}

}
