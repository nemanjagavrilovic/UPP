package com.upp.upp.camundaListeners;

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
import com.upp.upp.repository.UserRepository;

@Service
public class AddCoauthor implements ExecutionListener{

	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CamundaUserToUserConverter camundaUserToUserConverter;
	@Override
	public void notify(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		Article article = (Article) execution.getVariable("article");
		Optional<Article> articleFromDatabase = articleRepository.findById(article.getId());
		List<FormSubmissionDto> coauthorsForm = (List<FormSubmissionDto>) execution.getVariable("addCoauthor");
		String firstName = "";
		String lastName = "";
		String email = "";
		String city = "";
		String country = "";
		String addMore = "";
		for(FormSubmissionDto dto : coauthorsForm) {
			if(dto.getFieldId().equals("firstName")) {
				firstName = dto.getFieldValue();
			} else if(dto.getFieldId().equals("lastName")) {
				lastName = dto.getFieldValue();
			} else if(dto.getFieldId().equals("email")) {
				email = dto.getFieldValue();
			} else if(dto.getFieldId().equals("city")) {
				city = dto.getFieldValue();
			} else if(dto.getFieldId().equals("country")) {
				country = dto.getFieldValue();
			} else if(dto.getFieldId().equals("addMore")) {
				addMore = dto.getFieldValue();
			}
		}
		CamundaUser coauthor = new CamundaUser(firstName,lastName,country,city,email);
		CamundaUser userFromDatabase = userRepository.findByEmail(email);
		if(userFromDatabase != null){
			articleFromDatabase.get().getAuthors().add(camundaUserToUserConverter.convert(userFromDatabase));
		} else {
			coauthor = userRepository.save(coauthor);
			articleFromDatabase.get().getAuthors().add(camundaUserToUserConverter.convert(coauthor));
		}
		
		if(addMore.equals("true")) {
			execution.setVariable("addMore", true);
		} else {
			execution.setVariable("addMore", false);
		}
	}

}