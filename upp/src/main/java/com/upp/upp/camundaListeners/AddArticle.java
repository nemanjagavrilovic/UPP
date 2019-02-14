package com.upp.upp.camundaListeners;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upp.upp.lucene.Article;
import com.upp.upp.model.FormSubmissionDto;
import com.upp.upp.model.Magazine;
import com.upp.upp.repository.ArticleRepository;
import com.upp.upp.repository.MagazineRepository;

@Service
public class AddArticle implements ExecutionListener{

	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private MagazineRepository magazineRepository;
	
	@Override
	public void notify(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		String chooseMagazine = (String) execution.getVariable("chooseMagazine");
		String loggedUser = (String) execution.getVariable("loggedUser");
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
		Article article = new Article();
		article.setMagazine(magazine.get());
		article.setMagazineName(magazine.get().getTitle());
		article.setScientificField(magazine.get().getScientificField());
		article.setFilename(filename);
		article = articleRepository.save(article);
		execution.setVariable("article", article);
		execution.setVariable("articleFile", new File(article.getFilename()));
	}

}
