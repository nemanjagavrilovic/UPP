package com.upp.upp.camundaService;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import com.upp.upp.lucene.Article;

@Service
public class PrintArticle implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		Article article = (Article) execution.getVariable("article");
		System.out.println(article.getFile());
	}

}
