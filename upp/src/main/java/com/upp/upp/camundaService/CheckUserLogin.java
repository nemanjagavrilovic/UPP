package com.upp.upp.camundaService;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.impl.context.Context;
import org.camunda.bpm.engine.impl.identity.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upp.upp.repository.MagazineRepository;
import com.upp.upp.repository.UserRepository;

@Service
public class CheckUserLogin implements JavaDelegate {

	@Autowired
	private UserRepository userRepositroy;

	@Autowired
	private MagazineRepository magazineRepository;
	
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		IdentityService identityService = Context.getProcessEngineConfiguration().getIdentityService();
		Authentication currentAuthentication = identityService.getCurrentAuthentication();
		if (currentAuthentication != null && currentAuthentication.getUserId() != null) {
			execution.setVariable("loggedUser", currentAuthentication.getUserId());
		} else {
			execution.setVariable("loggedUser", "");
		}
	}

}
