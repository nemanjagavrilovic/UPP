package com.upp.upp.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.upp.upp.lucene.Article;
import com.upp.upp.lucene.ArticleTransport;

@Component
public class ArticleToArticleTransport implements Converter<Article,ArticleTransport> {

	@Override
	public ArticleTransport convert(Article source) {
		// TODO Auto-generated method stub
		ArticleTransport article = new ArticleTransport();
		article.setAbstracts(source.getAbstracts());
		article.setAuthors(source.getAuthors());
		article.setFilename(source.getFilename());
		article.setKeywords(source.getKeywords());
		article.setMagazineName(source.getMagazineName());
		article.setReviewers(source.getReviewers());
		article.setScientificField(source.getScientificField());
		article.setTitle(source.getTitle());
		article.setFile(source.getFile());
		article.setContent(source.getContent());
		return article;
	}

}
