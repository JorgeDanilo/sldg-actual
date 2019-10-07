package com.sldg.erp.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="userData", eager= true)
@SessionScoped
public class UserData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String data = "1";
	
	public String teste = "Ola testando!";
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public void setTeste(String teste) {
		this.teste = teste;
	}
	
	public String getTeste() {
		return teste;
	}
	
	
	
}
