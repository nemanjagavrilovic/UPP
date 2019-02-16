package com.upp.upp.camundaListeners;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upp.upp.converter.CamundaUserToUserConverter;
import com.upp.upp.lucene.Article;
import com.upp.upp.lucene.User;
import com.upp.upp.model.CamundaUser;
import com.upp.upp.model.FormSubmissionDto;
import com.upp.upp.model.Magazine;
import com.upp.upp.pdf.PDFHandler;
import com.upp.upp.repository.ArticleRepository;
import com.upp.upp.repository.CamundaUserRepository;
import com.upp.upp.repository.MagazineRepository;
import com.upp.upp.repository.UserRepository;

@Service
public class AddArticle implements ExecutionListener{

	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private MagazineRepository magazineRepository;
	
	@Autowired
	private CamundaUserRepository camundaUserRepository;
	
	@Autowired
	private CamundaUserToUserConverter camundaUserToUserConverter;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PDFHandler pdfHandler;
	@Override
	public void notify(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		String chooseMagazine = (String) execution.getVariable("chooseMagazine");
		String loggedUser = (String) execution.getVariable("loggedUser");
		CamundaUser logged = camundaUserRepository.findByUsername(loggedUser);
		List<FormSubmissionDto> articleForm = (List<FormSubmissionDto>) execution.getVariable("addArticle");
		Optional<Magazine> magazine = magazineRepository.findById(Long.parseLong(chooseMagazine));
		String file = "";
		String filename = "";
		for(FormSubmissionDto dto : articleForm) {
			if(dto.getFieldId().equals("file")) {
				file= dto.getFieldValue();
			} else if(dto.getFieldId().equals("filename")) {
				filename = dto.getFieldValue();
			}
		}
		User user = userRepository.findByEmail(logged.getEmail());
		if(user == null) {
			user = userRepository.save(camundaUserToUserConverter.convert(logged));
		}
		Article article = pdfHandler.getIndexUnit(new File(filename));
		article.getAuthors().add(user);
		article.setMagazine(magazine.get());
		article.setMagazineName(magazine.get().getTitle());
		article.setScientificField(magazine.get().getScientificField());
		article.setFilename(filename);
		article = articleRepository.save(article);
		execution.setVariable("article", article);
		execution.setVariable("articleFile", new File(article.getFilename()));
	}

}
