package com.upp.upp.camundaService;

import java.util.List;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.impl.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upp.upp.model.FormSubmissionDto;
import com.upp.upp.model.CamundaUser;
import com.upp.upp.repository.UserRepository;

@Service
public class CheckUserRegistration implements JavaDelegate {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private IdentityService identityService;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		List<FormSubmissionDto> login = (List<FormSubmissionDto>) execution.getVariable("signIn");
		String username = "";
		String password = "";
		for (FormSubmissionDto dto : login) {
			if (dto.getFieldId().equals("username"))
				username = dto.getFieldValue();
			else if (dto.getFieldId().equals("password"))
				password = dto.getFieldValue();
		}
		CamundaUser user = userRepository.findByUsername(username);
		
		if( user == null ) {
			user = userRepository.save(new CamundaUser(username,password));

	        org.camunda.bpm.engine.identity.User newUser = identityService.newUser(user.getUsername());
	        newUser.setPassword(password);
			identityService.saveUser(newUser);
			execution.setVariable("registeredUser", user);
		}else {
			execution.setVariable("registeredUser", null);
		}
		
	}

}
