package com.assignment.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.model.UserNote;
import com.assignment.service.UserNotesService;
import com.assignment.service.UserService;

@RestController
@RequestMapping("/usernotes")
public class UserNotesController {

	private final UserNotesService userNotesService;

	private final UserService userService;

	//Constructor Injection
	public UserNotesController(final UserNotesService userNotesService, final UserService userService) {
		this.userNotesService = userNotesService;
		this.userService = userService;
	}
	
	@GetMapping
	List<UserNote> readUserNotes() {
		return this.userNotesService.getAllUserNotes();
	}
}
