package com.upp.upp.camundaService;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upp.upp.lucene.Article;
import com.upp.upp.model.CamundaUser;
import com.upp.upp.repository.CamundaUserRepository;
import com.upp.upp.service.EmailService;

@Service
public class NotifyScietificFieldEditor implements JavaDelegate {

	@Autowired
	private CamundaUserRepository camundaUserRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		String username = (String) execution.getVariable("articleChiefReviewer");
		CamundaUser user =  camundaUserRepository.findByUsername(username);
		Article article = (Article) execution.getVariable("article");
//		emailService.getMail().setTo(user.getEmail());
//		emailService.getMail().setSubject("Request for publication"+article.getTitle());
//		emailService.getMail().setText("Your request for publication  has been received");
//		emailService.sendNotificaitionAsync(user);
	}

}
