package com.upp.upp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upp.upp.model.CamundaUser;
import com.upp.upp.repository.CamundaUserRepository;
import com.upp.upp.service.CamundaUserService;

@Service
public class CamundaUserServiceImpl implements CamundaUserService {

	@Autowired
	private CamundaUserRepository userRepository;
	
	@Override
	public CamundaUser findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return userRepository.findByUsernameAndPassword(username, password);
	}

}
