package com.upp.upp.camundaService;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upp.upp.model.CamundaUser;
import com.upp.upp.model.FormSubmissionDto;
import com.upp.upp.repository.CamundaUserRepository;

@Service
public class CandidateUsersAsignee implements TaskListener{

	@Autowired
	private CamundaUserRepository camundaUserRepository;

	@Override
	public void notify(DelegateTask delegateTask) {
		// TODO Auto-generated method stub
		List<String> candidates = new ArrayList<>();
		List<FormSubmissionDto> chooseReviewers = (List<FormSubmissionDto>) delegateTask.getVariable("chooseReviewers");
		for(FormSubmissionDto dto : chooseReviewers) {
			CamundaUser user = camundaUserRepository.findByEmail(dto.getFieldValue());
			candidates.add(user.getUsername());
			delegateTask.addCandidateUser(user.getUsername());
		}
		delegateTask.setVariable("candidateUsers", candidates);
	}

}
