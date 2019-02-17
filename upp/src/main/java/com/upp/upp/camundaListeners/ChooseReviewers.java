package com.upp.upp.camundaListeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upp.upp.converter.CamundaUserToUserConverter;
import com.upp.upp.lucene.Article;
import com.upp.upp.model.CamundaUser;
import com.upp.upp.model.FormSubmissionDto;
import com.upp.upp.repository.ArticleRepository;
import com.upp.upp.repository.CamundaUserRepository;
import com.upp.upp.repository.UserRepository;

@Service
public class ChooseReviewers implements ExecutionListener{

	@Autowired
	private CamundaUserRepository camundaUserRepository;

	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private CamundaUserToUserConverter camundaUserToUserConverter;
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public void notify(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		Article article = (Article) execution.getVariable("article");
		Optional<Article> articleFromDatabase = articleRepository.findById(article.getId());
		List<String> candidates = new ArrayList<>();
		List<FormSubmissionDto> chooseReviewers = (List<FormSubmissionDto>) execution.getVariable("chooseReviewers");
		for(FormSubmissionDto dto : chooseReviewers) {
			CamundaUser user = camundaUserRepository.findByEmail(dto.getFieldValue());
			candidates.add(user.getUsername());
			articleFromDatabase.get().getReviewers().add(userRepository.findByEmail(user.getEmail()));
		}
		article = articleRepository.save(articleFromDatabase.get());
		execution.setVariable("article", article);
		System.out.println(candidates.toString());
		execution.setVariable("candidateUsers", candidates);
	}

	
}
