package com.upp.upp.camundaService;

import java.util.List;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upp.upp.converter.CamundaUserToUserConverter;
import com.upp.upp.model.CamundaUser;
import com.upp.upp.model.FormSubmissionDto;
import com.upp.upp.repository.CamundaUserRepository;
import com.upp.upp.repository.UserRepository;

@Service
public class CheckUserRegistration implements JavaDelegate {

	@Autowired
	private CamundaUserRepository camundaUserRepository;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private CamundaUserToUserConverter camundaUserToUserConverter;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		List<FormSubmissionDto> login = (List<FormSubmissionDto>) execution.getVariable("signIn");
		String username = "";
		String password = "";
		String email = "";
		String firstName = "";
		String lastName = "";
		String city = "";
		String country = "";
		for (FormSubmissionDto dto : login) {
			if (dto.getFieldId().equals("username"))
				username = dto.getFieldValue();
			else if (dto.getFieldId().equals("password"))
				password = dto.getFieldValue();
			else if (dto.getFieldId().equals("email"))
				email = dto.getFieldValue();
			else if(dto.getFieldId().equals("firstName")) 
				firstName = dto.getFieldValue();
		    else if(dto.getFieldId().equals("lastName")) 
				lastName = dto.getFieldValue();
			else if(dto.getFieldId().equals("email")) 
				email = dto.getFieldValue();
			else if(dto.getFieldId().equals("city")) 
				city = dto.getFieldValue();
			else if(dto.getFieldId().equals("country")) 
				country = dto.getFieldValue();
		}
		CamundaUser user = camundaUserRepository.findByUsername(username);
		
		if( user == null ) {
			user = camundaUserRepository.save(new CamundaUser(username,password,firstName,lastName,country,city,email));
			userRepository.save(camundaUserToUserConverter.convert(user));
	        org.camunda.bpm.engine.identity.User newUser = identityService.newUser(user.getUsername());
	        newUser.setPassword(password);
	        newUser.setEmail(email);
			identityService.saveUser(newUser);
			execution.setVariable("registeredUser", user);
		}else {
			execution.setVariable("registeredUser", null);
		}
		
	}

}
