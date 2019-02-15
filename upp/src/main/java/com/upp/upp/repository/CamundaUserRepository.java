package com.upp.upp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.upp.upp.model.CamundaUser;

@Repository
public interface CamundaUserRepository extends PagingAndSortingRepository<CamundaUser,Long>{

	public CamundaUser findByUsernameAndPassword(String username, String password);
	public CamundaUser findByUsername(String username);
	public CamundaUser findByEmail(String email);
	
}
