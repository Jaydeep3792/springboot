package com.assignment.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.assignment.model.UserNote;
import com.assignment.repository.UserNotesDAO;
import com.assignment.util.DateUtil;

@Service
@Transactional
public class UserNotesServiceImpl implements UserNotesService {

	private UserNotesDAO userNotesDAO;

	// Constructor injection
	public UserNotesServiceImpl(UserNotesDAO repository) {
		this.userNotesDAO = repository;
	}

	/*
	 * Below service layer method will Provide all notes associated with user
	 * 
	 * @OutputParam List of UserNote
	 */
	@Override
	public List<UserNote> getAllUserNotes(int userId) {
		return userNotesDAO.getAllUserNotes(userId);
	}

	/*
	 * Below service layer method create note for user
	 * 
	 * @OutputParam UserNote Object
	 */
	@Override
	public UserNote createUserNote(UserNote userNote) {
		UserNote newUserNote = new UserNote();
		newUserNote.setTitle(userNote.getTitle());
		newUserNote.setNotes(userNote.getNotes());
		newUserNote.setUserId(userNote.getUserId());
		newUserNote.setUpdateTime(DateUtil.getCurrentUTCTimeStamp());
		newUserNote.setCreateTime(DateUtil.getCurrentUTCTimeStamp());
		return userNotesDAO.createUserNote(newUserNote);
	}

	/*
	 * Below service layer method, updates note and title for user
	 * 
	 * @OutputParam String
	 */
	@Override
	public String updateUserNote(UserNote userNote, int currentUserId) {
		UserNote note = getNote(userNote.getNoteId());
		if (note == null) {
			return "No Record to Update";
		} else if (note.getUserId() == currentUserId) {
			note.setTitle(userNote.getTitle());
			note.setNotes(userNote.getNotes());
			note.setUpdateTime(DateUtil.getCurrentUTCTimeStamp());
			return userNotesDAO.updateUserNote(note);
		} else {
			return "Cannot Update, Note is not belongs to you";
		}
	}

	/*
	 * Below service layer method, delete specific usernote
	 * 
	 * @OutputParam String
	 */
	@Override
	public String deleteUserNote(int noteId, int currentUserId) {
		UserNote currentNote = getNote(noteId);
		if (currentNote == null) {
			return "No Record to delete";
		} else if (currentNote.getUserId() == currentUserId) {
			return userNotesDAO.deleteUserNote(currentNote);
		} else {
			return "Cannot delete, Note is not belongs to you";
		}
	}

	/*
	 * Below service layer method, used to get Note for validation
	 * 
	 * @OutputParam UserNote object
	 */
	
	private UserNote getNote(int noteId) {
		return userNotesDAO.getNote(noteId);
	}

}
