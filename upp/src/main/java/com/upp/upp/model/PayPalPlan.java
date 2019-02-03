package com.upp.upp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PayPalPlan {
	

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
	private Long magazineId;
	
    @Column
    private String planName;
    
	@Column
	private String planDescription;
	
	@Column
	private String planCurrency;
	
	@Column
	private String planFrequency;
	
	@Column
	private String planReturnUrl;
	
	@Column
	private String planCancelUrl;
	
	@Column
	private String payPalId;

	public PayPalPlan() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getMagazineId() {
		return magazineId;
	}

	public String getPlanDescription() {
		return planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	public String getPlanCurrency() {
		return planCurrency;
	}

	public void setPlanCurrency(String planCurrency) {
		this.planCurrency = planCurrency;
	}

	public String getPlanFrequency() {
		return planFrequency;
	}

	public void setPlanFrequency(String planFrequency) {
		this.planFrequency = planFrequency;
	}

	public String getPlanReturnUrl() {
		return planReturnUrl;
	}

	public void setPlanReturnUrl(String planRetrunUrl) {
		this.planReturnUrl = planRetrunUrl;
	}

	public String getPlanCancelUrl() {
		return planCancelUrl;
	}

	public void setPlanCancelUrl(String planCancelUrl) {
		this.planCancelUrl = planCancelUrl;
	}

	public String getPayPalId() {
		return payPalId;
	}

	public void setPayPalId(String payPalId) {
		this.payPalId = payPalId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public void setMagazineId(Long magazineId) {
		this.magazineId = magazineId;
	}
	
	
}
