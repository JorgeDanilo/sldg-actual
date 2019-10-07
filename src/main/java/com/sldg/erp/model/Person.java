package com.sldg.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.sldg.erp.model.enuns.EnumSex;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person extends AbstractEntity<Long> {

	@Column(name = "name")
	private String name;

	@Column(name = "genger")
	@Enumerated(EnumType.STRING)
	private EnumSex gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EnumSex getGender() {
		return gender;
	}

	public void setGender(EnumSex gender) {
		this.gender = gender;
	}

}
