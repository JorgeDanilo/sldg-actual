package com.sldg.erp.repository;

public interface LoginRepository<T> {

	T auth(T t);
	
}
