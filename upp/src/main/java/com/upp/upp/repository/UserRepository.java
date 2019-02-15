package com.upp.upp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.upp.upp.lucene.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {

	
	public User findByEmail(String email);
	
}
