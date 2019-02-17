package com.upp.upp.camundaListeners;

import java.util.List;
import java.util.Optional;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upp.upp.lucene.Article;
import com.upp.upp.model.FormSubmissionDto;
import com.upp.upp.repository.ArticleRepository;

@Service
public class Review implements ExecutionListener{

	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public void notify(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		Article article= (Article) execution.getVariable("article");
		Optional<Article> articleFromDatabase = articleRepository.findById(article.getId());
		List<FormSubmissionDto> reviewForm = (List<FormSubmissionDto>) execution.getVariable("review");
		String commentForAuthors = "";
		String commentForEditors = "";
		String suggestion = "";
		for(FormSubmissionDto dto : reviewForm) {
			if(dto.getFieldId().equals("comment_for_editor")) {
				commentForEditors = dto.getFieldValue();
			} else if(dto.getFieldId().equals("comment_for_author")) {
				commentForAuthors = dto.getFieldValue();
			} else if(dto.getFieldId().equals("suggestion")) {
				suggestion = dto.getFieldValue();
			}
		}
		articleFromDatabase.get().getCommentsForAuthors().add(commentForAuthors);
		articleFromDatabase.get().getCommentsForEditors().add(commentForEditors);
		articleFromDatabase.get().getSuggestion().add(suggestion);
		article = articleRepository.save(articleFromDatabase.get());
		execution.setVariable("article", article);
	}

}
