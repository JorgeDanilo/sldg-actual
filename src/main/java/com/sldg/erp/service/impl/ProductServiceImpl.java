package com.sldg.erp.service.impl;

import java.io.Serializable;

import javax.inject.Inject;

import com.sldg.erp.model.Product;
import com.sldg.erp.repository.ProductRespository;
import com.sldg.erp.util.Transacional;

public class ProductServiceImpl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProductRespository produtoRespository;
	
	@Transacional
	public void salvar(Product produto) {
		this.produtoRespository.guardar(produto);
	}
	
}
