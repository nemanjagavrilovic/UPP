package com.upp.upp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.upp.upp.model.PayPalPlan;
import com.upp.upp.service.MagazineService;
import com.upp.upp.service.PayPalPlanService;

@Controller
@RequestMapping("/paypalPlan")
public class PaypalPlanController {

	@Autowired
	private MagazineService magazineService;
	
	@Autowired
	private PayPalPlanService paypalPlanService;
	
	@RequestMapping(value = "/" ,method=RequestMethod.GET)
	public String paypalPlan(HttpServletRequest request) {
		
		request.getSession().setAttribute("magazines", magazineService.findAll());
		return "redirect:/jsp/createPlan.jsp";
	}
	
	@RequestMapping(value = "/savePlan" ,method = RequestMethod.POST)
	public ResponseEntity<?> savePlan(@RequestBody PayPalPlan paypalPlan){
		PayPalPlan saved = paypalPlanService.save(paypalPlan);
		return new ResponseEntity<PayPalPlan> (saved,HttpStatus.OK);
	}
}
