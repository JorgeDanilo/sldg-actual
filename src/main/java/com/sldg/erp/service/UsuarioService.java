package com.sldg.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.sldg.erp.model.User;
import com.sldg.erp.repository.UsuarioRepository;
import com.sldg.erp.util.Transacional;

public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioRepository usuarioRepository;
	
	@Transacional
	public void salvar(User usuario) {
		usuarioRepository.save(usuario);
	}
	
	public void autenticar(User usuario) {
//		if ("".equals(usuario.getSenha()) || "".equals(usuario.getEmail())) {
//			throw new RuntimeException("Usuário ou senhas não informado");
//		} else {
//			usuarioRepository.autentica(usuario);
//		}
	}
	
}
