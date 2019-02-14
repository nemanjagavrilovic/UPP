package com.upp.upp.camundaListeners;

import java.util.Optional;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upp.upp.model.CamundaUser;
import com.upp.upp.model.Magazine;
import com.upp.upp.repository.MagazineRepository;
import com.upp.upp.repository.UserRepository;

@Service
public class ChooseMagazine implements ExecutionListener {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MagazineRepository magazineRepository;
	
	@Override
	public void notify(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		String chooseMagazine = (String) execution.getVariable("chooseMagazine");
		String loggedUser = (String) execution.getVariable("loggedUser");
		Optional<Magazine> magazine = magazineRepository.findById(Long.parseLong(chooseMagazine));
		boolean isMember = false;
		for(CamundaUser user : magazine.get().getMemberships()) {
			if(user.getUsername().equals(loggedUser)){
				isMember = true;
				break;
			}
		}
		if(isMember == true)
			execution.setVariable("membershipFee", true);
		else 
			execution.setVariable("membershipFee", false);
	}

}
