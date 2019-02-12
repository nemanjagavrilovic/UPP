package com.upp.upp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.upp.upp.lucene.Article;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article,Long> {

}
