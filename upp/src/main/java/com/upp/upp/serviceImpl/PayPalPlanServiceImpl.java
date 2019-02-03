package com.upp.upp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upp.upp.model.PayPalPlan;
import com.upp.upp.repository.PayPalPlanRepository;
import com.upp.upp.service.PayPalPlanService;

@Service
public class PayPalPlanServiceImpl implements PayPalPlanService{

	@Autowired
	private PayPalPlanRepository payPalPlanRepository;
	
	@Override
	public PayPalPlan save(PayPalPlan payPalPlan) {
		// TODO Auto-generated method stub
		return payPalPlanRepository.save(payPalPlan);
	}

	@Override
	public Optional<PayPalPlan> findOne(Long id) {
		// TODO Auto-generated method stub
	
		return payPalPlanRepository.findById(id);
	}

	@Override
	public List<PayPalPlan> findAll() {
		// TODO Auto-generated method stub
		return payPalPlanRepository.findAll();
	}

	@Override
	public PayPalPlan findByMagazineId(Long id) {
		// TODO Auto-generated method stub
		return payPalPlanRepository.findByMagazineId(id);
	}

}
