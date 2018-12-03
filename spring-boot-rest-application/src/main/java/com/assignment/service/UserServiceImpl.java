package com.assignment.service;

import org.springframework.stereotype.Service;

import com.assignment.model.User;

@Service(value = "userDetailsService")
public class UserServiceImpl implements UserService {

	@Override
	public User getUserDetails() {
		return null;
	}

}
