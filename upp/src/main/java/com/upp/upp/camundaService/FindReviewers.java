package com.upp.upp.camundaService;

import java.io.File;

import javax.xml.bind.JAXBElement;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upp.upp.client.ArticleClient;
import com.upp.upp.converter.ArticleToArticleTransport;
import com.upp.upp.lucene.Article;
import com.upp.upp.pdf.PDFHandler;
import com.upp.upp.requestAndresponse.ArticleFindByDistanceResponse;
import com.upp.upp.requestAndresponse.ArticleMoreLikeThisResponse;

@Service
public class FindReviewers implements JavaDelegate{

	@Autowired
	private ArticleClient articleClient;
	
	@Autowired
	private PDFHandler pdfHandler;
	
	@Autowired
	private ArticleToArticleTransport articleToArticleTransport;
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		Article article = (Article) execution.getVariable("article");
		JAXBElement<ArticleFindByDistanceResponse> byDistance = articleClient.findByDistance(articleToArticleTransport.convert(article));
		String filename = "D:\\Fakultet\\6 semestar\\Web\\WEB-work\\UPP\\upp\\src\\main\\webapp\\data"+File.separator+article.getFilename();
		JAXBElement<ArticleMoreLikeThisResponse> response = articleClient.moreLikeThis(pdfHandler.getText(new File(filename)));
		execution.setVariable("byDistance", byDistance.getValue().getReviewers());
		execution.setVariable("moreLikeThis", response.getValue().getArticles());
		
	}

}
