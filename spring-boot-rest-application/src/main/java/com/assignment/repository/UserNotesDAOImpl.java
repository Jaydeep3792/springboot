package com.assignment.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.assignment.model.UserNote;

@Repository
public class UserNotesDAOImpl implements UserNotesDAO{

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserNote> getAllUserNotes() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserNote.class);
		return criteria.list();
	}

}
