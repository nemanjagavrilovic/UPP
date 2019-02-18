package com.upp.upp.camundaListeners;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upp.upp.lucene.Article;
import com.upp.upp.model.FormSubmissionDto;
import com.upp.upp.pdf.PDFHandler;
import com.upp.upp.repository.ArticleRepository;

@Service
public class ReworkArticle implements ExecutionListener {

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private PDFHandler pdfHandler;

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		Article article = (Article) execution.getVariable("article");
		
		List<FormSubmissionDto> articleForm = (List<FormSubmissionDto>) execution.getVariable("rework");
		String filename = "";
		for(FormSubmissionDto dto : articleForm) {
			if(dto.getFieldId().equals("filename")) {
				filename = dto.getFieldValue();
			}
		}
		Article newArticle = pdfHandler.getIndexUnit(new File(filename));
		Optional<Article> articleFromDatabase = articleRepository.findById(article.getId());
		articleFromDatabase.get().setFilename(newArticle.getFilename());
		articleFromDatabase.get().setTitle(newArticle.getTitle());
		articleFromDatabase.get().setKeywords(newArticle.getKeywords());
		
		article = articleRepository.save(articleFromDatabase.get());
		execution.setVariable("article", article);
		execution.setVariable("articleFile", new File(newArticle.getFilename()));
	}

}
