package com.assignment.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.assignment.model.UserNote;
import com.assignment.repository.UserNotesDAO;

@Service
@Transactional
public class UserNotesServiceImpl implements UserNotesService {

	private UserNotesDAO userNotesDAO;

	public UserNotesServiceImpl(UserNotesDAO repository) {
		this.userNotesDAO = repository;
	}

	@Override
	public List<UserNote> getAllUserNotes() {
		return userNotesDAO.getAllUserNotes();
	}

}
