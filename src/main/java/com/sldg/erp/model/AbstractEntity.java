package com.sldg.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity<T extends Serializable> implements SimpleModel<T> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private T id;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private EnumStatus status = EnumStatus.ENABLE;

	@Override
	public T getId() {
		return null;
	}

	public void setId(T id) {
		this.id = id;
	}

	public EnumStatus getStatus() {
		return status;
	}

	public void setStatus(EnumStatus status) {
		this.status = status;
	}

}
