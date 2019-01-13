package com.upp.upp.service;

import com.upp.upp.model.User;

public interface UserService {

	public User findByUsernameAndPassword(String username, String password);
}
