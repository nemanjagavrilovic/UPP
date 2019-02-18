package com.upp.upp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

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
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private FormService formService;

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
	
	@RequestMapping(value = "/executeAgreement" ,method = RequestMethod.GET)
	public void executeAgreement(HttpServletRequest request,HttpServletResponse response){
		String loggedUser = (String) request.getSession().getAttribute("loggedUser");
		String url = "https://localhost:9001/paypal/executeAgreement?token="+request.getParameter("token");
		List<Task> tasks = taskService.createTaskQuery().taskAssignee(loggedUser).list();
		for(Task task : tasks) {
			if(task.getName().equals("Subscribe")) {
				taskService.complete(task.getId());
			}
		}
		HttpHeaders httpHeaders = restTemplate
	        		  .headForHeaders(url);
	        String returnURL = httpHeaders.get("ReturnURL").toString().replace("[", "").replace("]", "");
	        response.setHeader("Location", returnURL);
	        response.setStatus(302);
	      
	}
}
