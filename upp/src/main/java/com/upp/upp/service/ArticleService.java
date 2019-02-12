package com.upp.upp.service;

import java.util.Optional;

import com.upp.upp.lucene.Article;

public interface ArticleService {

	public Iterable<Article> findAll();
	public Optional<Article> findOne(Long id);
}
