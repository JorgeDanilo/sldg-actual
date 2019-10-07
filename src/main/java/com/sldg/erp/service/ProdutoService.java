package com.sldg.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.sldg.erp.model.Produto;
import com.sldg.erp.repository.Produtos;
import com.sldg.erp.util.Transacional;

public class ProdutoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;
	
	@Transacional
	public void salvar(Produto produto) {
		this.produtos.guardar(produto);
	}
	
}
