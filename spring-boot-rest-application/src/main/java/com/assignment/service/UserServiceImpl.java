package com.assignment.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.assignment.model.User;
import com.assignment.repository.UserDAO;

@Service(value = "userDetailsService")
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	
	/*
	 * Below method will Provide User Details for provided userId
	 * 
	 * @InputParam None
	 * Took userId from SecurityContextHolder 
	 * 
	 * @OutputParam User Object
	 */
	@Override
	public User getUserDetails() {
		// Get Current User Information from Security Context
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userDAO.findByUsername(userDetails.getUsername());
	}

}
