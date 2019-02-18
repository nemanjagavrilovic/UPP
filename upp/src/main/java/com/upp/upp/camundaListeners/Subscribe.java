package com.upp.upp.camundaListeners;

import java.util.Optional;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upp.upp.model.CamundaUser;
import com.upp.upp.model.Magazine;
import com.upp.upp.repository.CamundaUserRepository;
import com.upp.upp.repository.MagazineRepository;

@Service
public class Subscribe implements ExecutionListener{

	@Autowired
	private CamundaUserRepository userRepository;
	
	@Autowired
	private MagazineRepository magazineRepository;
	
	@Override
	public void notify(DelegateExecution execution) throws Exception {
		String chooseMagazine = (String) execution.getVariable("chooseMagazine");
		String loggedUser = (String) execution.getVariable("loggedUser");
		Optional<Magazine> magazine = magazineRepository.findById(Long.parseLong(chooseMagazine));
		CamundaUser user = userRepository.findByUsername(loggedUser);
		magazine.get().getMemberships().add(user);
		magazineRepository.save(magazine.get());
		execution.setVariable("paid", true);
	}

}
