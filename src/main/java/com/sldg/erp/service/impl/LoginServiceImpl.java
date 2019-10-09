package com.sldg.erp.service.impl;

import javax.inject.Inject;

import com.sldg.erp.model.User;
import com.sldg.erp.repository.impl.LoginRepositoryImpl;
import com.sldg.erp.service.LoginService;

public class LoginServiceImpl extends LoginService {

	@Inject
	private LoginRepositoryImpl loginRepository;
	
	private User user;
	
	@Override
	public User auth(User user) {
		if ("".equals(user.getPassword()) || "".equals(user.getUserName()))
			throw new RuntimeException("Usuário ou senha não informado");
		else
			user = loginRepository.auth(user);
		return user;
	}
	
}
