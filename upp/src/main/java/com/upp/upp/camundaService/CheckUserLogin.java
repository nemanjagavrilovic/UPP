package com.upp.upp.camundaService;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upp.upp.model.FormSubmissionDto;
import com.upp.upp.model.User;
import com.upp.upp.repository.UserRepository;

@Service
public class CheckUserLogin implements JavaDelegate {

	@Autowired
	private UserRepository userRepositroy;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		List<FormSubmissionDto> login = (List<FormSubmissionDto>) execution.getVariable("login");
		String username = "";
		String password = "";
		for (FormSubmissionDto dto : login) {
			if (dto.getFieldId().equals("username"))
				username = dto.getFieldValue();
			else if (dto.getFieldId().equals("password"))
				password = dto.getFieldValue();
		}
		User user = userRepositroy.findByUsernameAndPassword(username, password);
		if (user != null) {
			execution.setVariable("loggedUser", user.getUsername());
		} else
			execution.setVariable("loggedUser", "");
	}

}
