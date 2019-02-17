package com.upp.upp.camundaService;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upp.upp.client.ArticleClient;
import com.upp.upp.converter.ArticleToArticleTransport;
import com.upp.upp.lucene.Article;
import com.upp.upp.repository.ArticleRepository;

@Service
public class Indexing implements JavaDelegate{

	@Autowired
	private ArticleClient articleClient;
	
	@Autowired
	private ArticleToArticleTransport articleToArticleTransport;
	
	@Autowired
	private ArticleRepository articleRepository;
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		Article article = (Article)execution.getVariable("article");
		articleClient.save(articleToArticleTransport.convert(article));
		articleRepository.save(article);
	}

}
