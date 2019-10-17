package com.sldg.erp.controller;

import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.sldg.erp.controller.impl.ProductController;
import com.sldg.erp.model.Product;
import com.sldg.erp.model.enuns.TipoCategoria;
import com.sldg.erp.repository.ProductRespository;
import com.sldg.erp.service.impl.ProductServiceImpl;
import com.sldg.erp.util.FacesMessages;

@Named
@ViewScoped
public class ProdutoController implements ProductController<Product> {

	@Inject
	private ProductRespository produtos;

	@Inject
	private ProductServiceImpl produtoService;
	
	@Inject
	private FacesMessages facesMessages;
	
	private List<Product> todosProduto;

	private Product produtoEdicao = new Product();
	
	private Boolean marcarProduto;
	
	public void marcarProdutosCompra() {
		System.out.println("Aceitou Comprar Produto: " + this.marcarProduto);
		System.out.println("Nome Produto: " + this.produtoEdicao.getNomeProduto());
	}
	
	
	public void salvar() {
		this.produtoService.salvar(produtoEdicao);
		facesMessages.info("Produto Cadastrado!");
	}
	
	public void listaProdutos() {
		this.todosProduto = produtos.listaProduto();
	}
	
	public void pesquisaProduto() {
		this.todosProduto = produtos.pesquisaProdutos(produtoEdicao);
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:tabelaProdutos"));
	}
	
		
	public TipoCategoria[] getTipoCategorias() {
		return TipoCategoria.values();
	}
	
	public ProductRespository getProdutos() {
		return produtos;
	}

	public void setProdutos(ProductRespository produtos) {
		this.produtos = produtos;
	}

	public ProductServiceImpl getProdutoService() {
		return produtoService;
	}

	public void setProdutoService(ProductServiceImpl produtoService) {
		this.produtoService = produtoService;
	}

	public Product getProdutoEdicao() {
		return produtoEdicao;
	}

	public void setProdutoEdicao(Product produtoEdicao) {
		this.produtoEdicao = produtoEdicao;
	}
	
	public List<Product> getTodosProduto() {
		return todosProduto;
	}
	
	public void setTodosProduto(List<Product> todosProduto) {
		this.todosProduto = todosProduto;
	}

	public Boolean getMarcarProduto() {
		return marcarProduto;
	}

	public void setMarcarProduto(Boolean marcarProduto) {
		this.marcarProduto = marcarProduto;
	}
	
	

}
