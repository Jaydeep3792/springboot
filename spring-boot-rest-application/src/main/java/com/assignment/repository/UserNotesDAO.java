package com.assignment.repository;

import java.util.List;

import com.assignment.model.UserNote;

public interface UserNotesDAO {

	 List<UserNote> getAllUserNotes(int userId);
	
	 UserNote createUserNote(UserNote userNote);

	 String updateUserNote(UserNote newUserNote);

	 String deleteUserNote(UserNote userNote);

	 UserNote getNote(int noteId);

}
