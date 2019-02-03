package com.upp.upp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upp.upp.model.PayPalPlan;

@Repository
public interface PayPalPlanRepository extends JpaRepository<PayPalPlan,Long> {

	public PayPalPlan findByMagazineId(Long id);
}
