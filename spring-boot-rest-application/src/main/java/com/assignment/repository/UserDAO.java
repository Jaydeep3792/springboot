package com.assignment.repository;

import java.util.List;

import com.assignment.model.User;

public interface UserDAO {

	User findByUsername(String username);

	List<User> findAll();  
}
