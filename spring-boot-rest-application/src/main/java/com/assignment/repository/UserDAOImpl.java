package com.assignment.repository;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.assignment.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Resource(name="sessionFactory") 
	private SessionFactory sessionFactory;

	// Setter injection
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * Below DAO layer method provide User information for specific userId
	 * 
	 * @OutputParam User object
	 */
	@Override
	public User findByUsername(String userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("email", userId));

		return (User) criteria.uniqueResult();
	}

	/*
	 * Below DAO layer method all Users information
	 * 
	 * @OutputParam List of User
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		return criteria.list();
	}
}
