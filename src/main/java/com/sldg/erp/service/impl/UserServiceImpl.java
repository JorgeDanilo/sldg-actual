package com.sldg.erp.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.sldg.erp.model.User;
import com.sldg.erp.repository.impl.UserRepositoryImpl;
import com.sldg.erp.service.UserService;

public class UserServiceImpl implements UserService {

	@Inject
	private UserRepositoryImpl repository;
	
	public void save(User user) {
		this.repository.save(user);
	}
	
	public List<User> findAll() {
		return this.repository.findAll();
	}
	
	public User findById(Long id) {
		return this.repository.findById(id);
	}
	
}
