package com.upp.upp.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.upp.upp.lucene.User;
import com.upp.upp.model.CamundaUser;

@Component
public class CamundaUserToUserConverter implements Converter<CamundaUser,User> {

	@Override
	public User convert(CamundaUser source) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setEmail(source.getEmail());
		user.setFirstName(source.getFirstName());
		user.setLastName(source.getLastName());
		return user;
	}

}
