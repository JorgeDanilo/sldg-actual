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

	public User findByCode(Long codigo) {
		return manager.find(User.class, codigo);
	}

	public User save(User usuario) {
		return manager.merge(usuario);
	}

	public List<User> findAll() {
		Query query = manager.createQuery("from Usuario", User.class);
		return query.getResultList();
	}

}
