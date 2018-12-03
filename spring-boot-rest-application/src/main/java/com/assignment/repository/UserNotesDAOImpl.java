package com.assignment.repository;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.assignment.constants.ApplicationConstants;
import com.assignment.model.UserNote;

@Repository
public class UserNotesDAOImpl implements UserNotesDAO {

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	// Setter injection
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * Below DAO layer method will Provide all notes associated with user
	 * Restrictions applied w.r.t userId
	 * @OutputParam List of UserNote
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<UserNote> getAllUserNotes(int userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserNote.class)
				.add(Restrictions.eq(ApplicationConstants.USERID, userId));
		return criteria.list();
	}

	/*
	 * Below DAO layer method create new UserNote
	 * 
	 * @OutputParam List of UserNote
	 */
	@Override
	public UserNote createUserNote(UserNote userNote) {
		int result = (int) sessionFactory.getCurrentSession().save(userNote);
		return ((result > 0) ? userNote : null);

	}

	/*
	 * Below DAO layer method update existing UserNote
	 * 
	 * @OutputParam String
	 */
	@Override
	public String updateUserNote(UserNote newUserNote) {
		if (newUserNote != null) {
			sessionFactory.getCurrentSession().update(newUserNote);
			return ApplicationConstants.RECORD_UPDATED;
		}
		return ApplicationConstants.FAILED_TO_UPDATE;
	}

	/*
	 * Below DAO layer method delete existing UserNote
	 * 
	 * @OutputParam String
	 */
	@Override
	public String deleteUserNote(UserNote currentNote) {
		if (currentNote != null) {
			sessionFactory.getCurrentSession().delete(currentNote);
			return ApplicationConstants.RECORD_DELETED;
		}
		return ApplicationConstants.FAILED_TO_DELETE;
	}

	/*
	 * Below DAO layer method provide for validation at service layer
	 * 
	 * @OutputParam UserNote object
	 */
	@Override
	public UserNote getNote(int noteId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserNote.class)
				.add(Restrictions.eq(ApplicationConstants.NOTEID, noteId));
		UserNote note = (UserNote) criteria.uniqueResult();
		return note;
	}

}
