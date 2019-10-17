package com.sldg.erp.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.sldg.erp.model.User;

public class UserRepositoryImpl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public User findById(Long id) {
		return manager.find(User.class, id);
	}

	public User save(User user) {
		return manager.merge(user);
	}
	
	public void delete(Long id) {
		User user = this.findById(id);
		if (user != null)
			manager.remove(user);
	}

	public List<User> findAll() {
		Query query = manager.createQuery("from User", User.class);
		return query.getResultList();
	}

}
