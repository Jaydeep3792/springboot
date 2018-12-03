package com.assignment.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.model.User;
import com.assignment.model.UserNote;
import com.assignment.service.UserNotesService;
import com.assignment.service.UserService;

@RestController
@RequestMapping("/usernotes")
public class UserNotesController {

	private final UserNotesService userNotesService;

	private final UserService userService;

	// Constructor Injection
	public UserNotesController(final UserNotesService userNotesService, final UserService userService) {
		this.userNotesService = userNotesService;
		this.userService = userService;
	}

	/*
	 * Below method will add/save new Note to database
	 * 
	 * @InputParam UserNote
	 * 
	 * @OutputParam UserNote Object
	 */
	@GetMapping
	List<UserNote> readUserNotes() {
		User currentUser = userService.getUserDetails();
		return this.userNotesService.getAllUserNotes(currentUser.getUserId());
	}

	/*
	 * Below method will add/save new Note to database
	 * 
	 * @InputParam UserNote
	 * 
	 * @OutputParam UserNote Object
	 */
	@PostMapping
	UserNote addUserNote(@RequestBody UserNote userNote) {
		User currentUser = userService.getUserDetails();
		return this.userNotesService.createUserNote(userNote, currentUser.getUserId());
	}

	/*
	 * Below method will Update existing Note to database
	 * 
	 * @InputParam UserNote
	 * 
	 * @OutputParam String
	 */
	@PutMapping
	String updateUserNote(@RequestBody UserNote userNote) {
		User currentUser = userService.getUserDetails();
		return this.userNotesService.updateUserNote(userNote, currentUser.getUserId());
	}

	/*
	 * Below method will Delete existing Note from database
	 * 
	 * @InputParam UserNote
	 * 
	 * @OutputParam String
	 */
	@DeleteMapping("/noteId/{noteId}")
	String deleteUserNote(@PathVariable int noteId) {
		User currentUser = userService.getUserDetails();
		return this.userNotesService.deleteUserNote(noteId, currentUser.getUserId());
	}
}
