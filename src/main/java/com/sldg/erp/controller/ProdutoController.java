package com.sldg.erp.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.sldg.erp.model.Produto;
import com.sldg.erp.model.enuns.TipoCategoria;
import com.sldg.erp.repository.Produtos;
import com.sldg.erp.service.ProdutoService;
import com.sldg.erp.util.FacesMessages;

@Named
@ViewScoped
public class ProdutoController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;

	@Inject
	private ProdutoService produtoService;
	
	@Inject
	private FacesMessages facesMessages;
	
	private List<Produto> todosProduto;

	private Produto produtoEdicao = new Produto();
	
	private Boolean marcarProduto;
	
	/**
	 * TODO: implementar;
	 */
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
	
	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}

	public ProdutoService getProdutoService() {
		return produtoService;
	}

	public void setProdutoService(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	public Produto getProdutoEdicao() {
		return produtoEdicao;
	}

	public void setProdutoEdicao(Produto produtoEdicao) {
		this.produtoEdicao = produtoEdicao;
	}
	
	public List<Produto> getTodosProduto() {
		return todosProduto;
	}
	
	public void setTodosProduto(List<Produto> todosProduto) {
		this.todosProduto = todosProduto;
	}

	public Boolean getMarcarProduto() {
		return marcarProduto;
	}

	public void setMarcarProduto(Boolean marcarProduto) {
		this.marcarProduto = marcarProduto;
	}
	
	

}
