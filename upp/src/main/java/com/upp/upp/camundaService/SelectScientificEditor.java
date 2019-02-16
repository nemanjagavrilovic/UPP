package com.upp.upp.camundaService;

import java.util.Optional;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upp.upp.lucene.Article;
import com.upp.upp.repository.ArticleRepository;

@Service
public class SelectScientificEditor implements JavaDelegate {

	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		Article article = (Article) execution.getVariable("article");
		Article articleFromDatabase = articleRepository.findById(article.getId()).get();
		if(articleFromDatabase != null) {
			if(articleFromDatabase.getMagazine().getScientificFieldEditor() != null) {
				execution.setVariable("articleChiefReviewer", articleFromDatabase.getMagazine().getScientificFieldEditor().getUsername());
			} else {
				execution.setVariable("articleChiefReviewer", articleFromDatabase.getMagazine().getEditor().getUsername());
			}
		}
	}

}
