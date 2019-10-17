package com.sldg.erp.controller;

import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.sldg.erp.controller.impl.UserController;
import com.sldg.erp.model.User;
import com.sldg.erp.repository.UserRepository;
import com.sldg.erp.service.impl.LoginServiceImpl;
import com.sldg.erp.util.FacesMessages;

@Named
@ViewScoped
public class UsuarioController implements UserController<User> {

	@Inject
	private LoginServiceImpl usuarioService;

	private User usuarioEdicao = new User();

	private List<User> todosUsuarios;

	@Inject
	private UserRepository usuarios;

	@Inject
	private FacesMessages messages;

	/**
	 * Metodo responsavel por carregar os dados no formulario
	 * 
	 * @author Danilo e Gessica
	 * @since 18/11/2015
	 */
	public void preparaNovoCadastro() {
		this.usuarioEdicao = new User();
	}

	/**
	 * Metodo responsavel por salvar os dados vindos do formulario.
	 * 
	 
	public void salvar() {
		this.usuarioService.salvar(usuarioEdicao);
		usuarioEdicao = new User();
		messages.info("Usuário Cadastrado!");
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:growl"));
	}/*

	/**
	 * Metodo responsavel por listar os usuarios
	 * 
	 * @since 20/11/2015
	 * @author Danilo e Gessica
	 */
	public void consultar() {
		this.todosUsuarios = usuarios.findAll();
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:tabela-usuarios"));
	}

//	TODO: Refresh tabel after search: RequestContext.getCurrentInstance().update(Arrays.asList("frm:tabela-usuarios"));
//	public void pesquisaUsuario() {
//		if(usuarioEdicao.getEmail() != "") {
//			this.todosUsuarios = usuarios.findByEmailAndCode(usuarioEdicao);
//			RequestContext.getCurrentInstance().update(Arrays.asList("frm:tabela-usuarios"));
//		} else {
//			consultar();
//		}
//		
//	}

	/*
	 * public void validarEmail(FacesContext fc, UIComponent component, Object
	 * value) throws ValidatorException { String email = value.toString(); if
	 * (!email.contains("@")) { throw new ValidatorException(new
	 * FacesMessage("Campo deve ser um e-mail válido")); } }
	 */

	public LoginServiceImpl getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(LoginServiceImpl usuarioService) {
		this.usuarioService = usuarioService;
	}

	public User getUsuarioEdicao() {
		return usuarioEdicao;
	}

	public void setUsuarioEdicao(User usuarioEdicao) {
		this.usuarioEdicao = usuarioEdicao;
	}

	public FacesMessages getMessages() {
		return messages;
	}

	public void setMessages(FacesMessages messages) {
		this.messages = messages;
	}

	public UserRepository getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(UserRepository usuarios) {
		this.usuarios = usuarios;
	}

	public List<User> getTodosUsuarios() {
		return todosUsuarios;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seach(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	

}
