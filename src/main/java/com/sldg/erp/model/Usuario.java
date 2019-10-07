package com.sldg.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

/**
 * Classe Modelo que representa o modelo de um usuario
 * 
 * @author Danilo e Gessica
 * 
 * @since 18/11/2015
 *
 */

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private Long codigo;
	
	@NaturalId
	@Column(name="email", length= 100)
	private String email;

	@NaturalId
	@Column(length=100)
	private String senha;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
