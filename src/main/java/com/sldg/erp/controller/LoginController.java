package com.sldg.erp.controller;

import java.io.IOException;
import java.io.Serializable;

import static org.apache.shiro.SecurityUtils.getSubject;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.jboss.weld.security.GetSystemPropertyAction;

import javax.faces.context.ExternalContext;

import com.sldg.erp.model.User;
import com.sldg.erp.repository.UserRepository;
import com.sldg.erp.service.impl.LoginServiceImpl;

@Named
@ViewScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UserRepository usuarios;
	
	@Inject
	private LoginServiceImpl usuarioService;
	
	private User usuario = new User();
	
	public void autenticar() {
//		getSubject().login(new UsernamePasswordToken(this.usuario.getEmail(), this.usuario.getSenha()));
		final ExternalContext cxt = this.getContext().getExternalContext();
		try {
			cxt.redirect(cxt.getRequestContextPath() + "/pesquisaProdutos.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean getIsLogged() {
		return false;
	}

	public UserRepository getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(UserRepository usuarios) {
		this.usuarios = usuarios;
	}

	public LoginServiceImpl getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(LoginServiceImpl usuarioService) {
		this.usuarioService = usuarioService;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * Metodo responsavel por retornar a instancia do objeto 
	 * @return
	 */
	private FacesContext getContext() {
		return FacesContext.getCurrentInstance();
	}
	
	public ExternalContext sair() {
		getSubject().logout();
		return this.inicio();
	}

	private ExternalContext inicio() {
		
		final ExternalContext cxt = this.getContext().getExternalContext();
		
		try {
			cxt.redirect(cxt.getRequestContextPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cxt; 
	}
	

}
