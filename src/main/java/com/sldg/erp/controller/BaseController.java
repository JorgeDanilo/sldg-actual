package com.sldg.erp.controller;

public interface BaseController<T> {

	void initialize();
	
	void seach(T t);
	
	void save(T t);
	
	void delete(Long id);
}
