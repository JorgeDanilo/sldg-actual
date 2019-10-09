package com.sldg.erp.service;

import java.util.List;

public interface BaseService<T> {

	T save();
	
	T update(Long id);
	
	T remove(Long id);
	
	T findOne(Long id);
	
	List<T> findAll();
}
