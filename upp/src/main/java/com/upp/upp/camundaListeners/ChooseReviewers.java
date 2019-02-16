package com.upp.upp.camundaListeners;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upp.upp.model.CamundaUser;
import com.upp.upp.model.FormSubmissionDto;
import com.upp.upp.repository.CamundaUserRepository;

@Service
public class ChooseReviewers implements ExecutionListener{

	@Autowired
	private CamundaUserRepository camundaUserRepository;

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		List<String> candidates = new ArrayList<>();
		List<FormSubmissionDto> chooseReviewers = (List<FormSubmissionDto>) execution.getVariable("chooseReviewers");
		for(FormSubmissionDto dto : chooseReviewers) {
			CamundaUser user = camundaUserRepository.findByEmail(dto.getFieldValue());
			candidates.add(user.getUsername());
			
		}
		System.out.println(candidates.toString());
		execution.setVariable("candidateUsers", candidates);
	}

	
}
