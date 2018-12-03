package com.assignment.service;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.assignment.model.User;
import com.assignment.repository.UserDAO;

@Service(value = "userDetailsService")
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDAO userDAO;

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

	
	/*
	 * Below method USED BY SPRING SECURITY TO AUTHENTICATE USER
	 *
	 * 
	 * @OutputParam UserDetails Object
	 */
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = userDAO.findByUsername(userId);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
}
