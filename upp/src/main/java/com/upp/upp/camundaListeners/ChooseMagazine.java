package com.upp.upp.camundaListeners;

import java.util.Map;
import java.util.Optional;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.upp.upp.model.CamundaUser;
import com.upp.upp.model.Magazine;
import com.upp.upp.model.PayPalPlan;
import com.upp.upp.repository.MagazineRepository;
import com.upp.upp.repository.PayPalPlanRepository;
import com.upp.upp.repository.UserRepository;

@Service
public class ChooseMagazine implements ExecutionListener {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MagazineRepository magazineRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private PayPalPlanRepository paypalRepository;

	
	@Override
	public void notify(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		String chooseMagazine = (String) execution.getVariable("chooseMagazine");
		String loggedUser = (String) execution.getVariable("loggedUser");
		Optional<Magazine> magazine = magazineRepository.findById(Long.parseLong(chooseMagazine));
		boolean isMember = false;
		if(magazine.get().isOpenAccess() == false) {
			for(CamundaUser user : magazine.get().getMemberships()) {
				if(user.getUsername().equals(loggedUser)){
					isMember = true;
					break;
				}
			}
		}
		if(isMember == false && magazine.get().isOpenAccess()) {
			execution.setVariable("membershipFee", true);
		} else if(isMember == true && magazine.get().isOpenAccess() == false) {
			execution.setVariable("membershipFee", true);
		}
		else {
			PayPalPlan plan = paypalRepository.findByPlanName(magazine.get().getTitle());
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			Map<String, Object> response = restTemplate.getForObject("https://localhost:9001/paypal/acceptPlan/"+plan.getPlanName(),Map.class);
			execution.setVariable("redirectURL", response.get("redirectURL"));
			execution.setVariable("membershipFee", false);
		}
	}

}
