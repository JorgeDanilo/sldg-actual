package com.sldg.erp.repository.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.sldg.erp.model.User;
import com.sldg.erp.repository.LoginRepository;

public class LoginRepositoryImpl implements LoginRepository<User> {

	@Inject
	private EntityManager manager;
	
	@Override
	public User auth(User user) {
		Session session = (Session) manager.getDelegate();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", user.getUserName().trim()));
		criteria.add(Restrictions.eq("password", user.getPassword().trim()));
		return (User) criteria.uniqueResult();
	}
	

	
	
}
