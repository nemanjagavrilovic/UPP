package com.upp.upp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.upp.upp.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long>{

	public User findByUsernameAndPassword(String username, String password);
	public User findByUsername(String username);
}
