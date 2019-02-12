package com.upp.upp.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upp.upp.lucene.Article;
import com.upp.upp.repository.ArticleRepository;
import com.upp.upp.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public Iterable<Article> findAll() {
		// TODO Auto-generated method stub
		return articleRepository.findAll();
	}

	@Override
	public Optional<Article> findOne(Long id) {
		// TODO Auto-generated method stub
		return articleRepository.findById(id);
	}
}
