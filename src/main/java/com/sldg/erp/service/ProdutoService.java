package com.sldg.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.sldg.erp.model.Product;
import com.sldg.erp.repository.ProdutoRespository;
import com.sldg.erp.util.Transacional;

public class ProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoRespository produtoRespository;
	
	@Transacional
	public void salvar(Product produto) {
		this.produtoRespository.guardar(produto);
	}
	
}
