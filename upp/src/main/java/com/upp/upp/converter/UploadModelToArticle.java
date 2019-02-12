package com.upp.upp.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.upp.upp.lucene.Article;
import com.upp.upp.lucene.UploadModel;

@Component
public class UploadModelToArticle implements Converter<UploadModel,Article>{

	@Override
	public Article convert(UploadModel arg0) {
		// TODO Auto-generated method stub
		Article article = new Article();
		article.setAbstracts(arg0.getAbstracts());
		article.setAuthors(arg0.getAuthors());
		article.setFilename(arg0.getFilename());
		article.setKeywords(arg0.getKeywords());
		article.setMagazineName(arg0.getMagazineName());
		article.setReviewers(arg0.getReviewers());
		article.setScientificField(arg0.getScientificField());
		article.setFile(arg0.getFile().substring(28, arg0.getFile().length()));
		return article;
	}

}
