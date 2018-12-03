package com.assignment.service;

import java.util.List;

import com.assignment.model.UserNote;

public interface UserNotesService {

	List<UserNote> getAllUserNotes(int userId);
	
    UserNote createUserNote(UserNote userNote,int userId);

    String updateUserNote(UserNote userNote,int currentUserId);

    String deleteUserNote(int noteId,int currentUserId);

}
