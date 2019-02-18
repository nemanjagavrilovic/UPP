package com.upp.upp.camundaService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.upp.upp.model.Magazine;
import com.upp.upp.model.PayPalPlan;
import com.upp.upp.repository.MagazineRepository;
import com.upp.upp.repository.PayPalPlanRepository;


@Service
public class MembershipFee implements JavaDelegate{

	@Autowired
	private MagazineRepository magazineRepository;
	
	@Autowired
	private PayPalPlanRepository paypalRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		String chooseMagazine = (String) execution.getVariable("chooseMagazine");
		Optional<Magazine> magazine = magazineRepository.findById(Long.parseLong(chooseMagazine));
//		PayPalPlan plan = paypalRepository.findByMagazineId(magazine.get().getId());
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		Map<String, Object> response = restTemplate.getForObject("https://localhost:9001/paypal/acceptPlan/"+plan.getPayPalId(),Map.class);
//		execution.setVariable("redirectURL", response.get("redirectURL"));
	}

}
