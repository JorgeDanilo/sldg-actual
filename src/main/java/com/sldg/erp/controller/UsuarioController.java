package com.sldg.erp.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.sldg.erp.model.Usuario;
import com.sldg.erp.repository.Usuarios;
import com.sldg.erp.service.UsuarioService;
import com.sldg.erp.util.FacesMessages;

@Named
@ViewScoped
public class UsuarioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService usuarioService;

	private Usuario usuarioEdicao = new Usuario();
	
	private List<Usuario> todosUsuarios;
	
	@Inject
	private Usuarios usuarios;

	@Inject
	private FacesMessages messages;

	/**
	 * Metodo responsavel por carregar os dados no formulario
	 * 
	 * @author Danilo e Gessica
	 * @since 18/11/2015
	 */
	public void preparaNovoCadastro() {
		this.usuarioEdicao = new Usuario();
	}

	/**
	 * Metodo responsavel por salvar os dados vindos do formulario.
	 * 
	 */
	public void salvar() {
		
		this.usuarioService.salvar(usuarioEdicao);
		
		usuarioEdicao = new Usuario();
		
		messages.info("Usuário Cadastrado!");
		
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:growl"));
		

	}
	
	/**
	 * Metodo responsavel por listar os usuarios
	 * @since 20/11/2015
	 * @author Danilo e Gessica 
	 */
	public void consultar() {
		this.todosUsuarios = usuarios.listaUsuario();
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:tabela-usuarios"));
	}
	
	public void pesquisaUsuario() {
		if(usuarioEdicao.getCodigo()!= null || usuarioEdicao.getEmail() != "") {
			this.todosUsuarios = usuarios.pesquisaUsuarios(usuarioEdicao);
			RequestContext.getCurrentInstance().update(Arrays.asList("frm:tabela-usuarios"));
		} else {
			consultar();
		}
		
	}

	public void validarEmail(FacesContext fc, UIComponent component, Object value) throws ValidatorException {
		String email = value.toString();
		if (!email.contains("@")) {
			throw new ValidatorException(new FacesMessage("Campo deve ser um e-mail válido"));
		}
	}
	
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}



	public Usuario getUsuarioEdicao() {
		return usuarioEdicao;
	}

	public void setUsuarioEdicao(Usuario usuarioEdicao) {
		this.usuarioEdicao = usuarioEdicao;
	}

	public FacesMessages getMessages() {
		return messages;
	}

	public void setMessages(FacesMessages messages) {
		this.messages = messages;
	}
	
	 public Usuarios getUsuarios() {
		return usuarios;
	}
	 
	 public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	 
	 public List<Usuario> getTodosUsuarios() {
		return todosUsuarios;
	}
	 

}
