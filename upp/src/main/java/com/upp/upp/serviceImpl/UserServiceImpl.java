package com.upp.upp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upp.upp.model.CamundaUser;
import com.upp.upp.repository.UserRepository;
import com.upp.upp.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public CamundaUser findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
