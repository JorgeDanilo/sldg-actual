package com.sldg.erp.controller;

import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.sldg.erp.controller.impl.UserController;
import com.sldg.erp.model.User;
import com.sldg.erp.service.impl.UserServiceImpl;
import com.sldg.erp.util.FacesMessages;

@Named("UserController")
@ViewScoped
public class UserControllerImpl implements UserController<User> {

	@Inject
	private UserServiceImpl userService;

	private User user = new User();

	private List<User> users;

	@Inject
	private FacesMessages messages;

	@Override
	public void initialize() {
		this.user = new User();
	}

	@Override
	public void seach() {
		this.users = this.userService.findAll();
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:tabela-usuarios"));
	}

	@Override
	public void save() {
		this.userService.save(user);
		this.initialize();
		messages.info("Usuário Cadastrado!");
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:growl"));
	}

	@Override
	public void delete() {

	}

	/*
	 * public void validarEmail(FacesContext fc, UIComponent component, Object
	 * value) throws ValidatorException { String email = value.toString(); if
	 * (!email.contains("@")) { throw new ValidatorException(new
	 * FacesMessage("Campo deve ser um e-mail válido")); } }
	 */

}
