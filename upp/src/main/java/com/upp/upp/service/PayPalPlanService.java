package com.upp.upp.service;

import java.util.List;
import java.util.Optional;

import com.upp.upp.model.PayPalPlan;

public interface PayPalPlanService {

	public PayPalPlan save(PayPalPlan payPalPlan);
	public Optional<PayPalPlan> findOne(Long id);
	public List<PayPalPlan> findAll();
	public PayPalPlan findByMagazineId(Long id);
}
