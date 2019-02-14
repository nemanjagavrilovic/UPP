package com.upp.upp.service;

import com.upp.upp.model.CamundaUser;

public interface UserService {

	public CamundaUser findByUsernameAndPassword(String username, String password);
}
