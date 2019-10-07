package com.sldg.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="legal_entity")
public class LegalEntity extends Person {
	
	@Column(name="cnpj")
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
