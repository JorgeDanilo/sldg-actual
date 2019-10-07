package com.sldg.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.sldg.erp.model.Produto;

public class Produtos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Produto guardar(Produto produto) {
		return this.manager.merge(produto);
	}
	
	/**
	 * 
	 * Método responsavel por listar todos os produtos
	 * 
	 * @author Danilo e Gessica
	 *  
	 * @since 22/11/2015
	 * 
	 * @return
	 */
	public List<Produto> listaProduto() {
		Session session = (Session) this.manager.getDelegate();
		Criteria criteria = session.createCriteria(Produto.class);
		
		return criteria.list();
	}
	
	
	/**
	 * Método responsavel por pesquisar os produtos por nome
	 * 
	 * @author Danilo e Gessica
	 * 
	 * @since 22/11/2015
	 * 
	 * @param produto
	 * @return
	 */
	public List<Produto> pesquisaProdutos(Produto produto) {
		Session session = (Session) this.manager.getDelegate();
		Criteria criteria = session.createCriteria(Produto.class);
		criteria.add(Restrictions.ilike("nomeProduto", produto.getNomeProduto(), MatchMode.ANYWHERE));
		criteria.add(Restrictions.ilike("marcaProduto", produto.getMarcaProduto(), MatchMode.ANYWHERE));
		return criteria.list();
	}

}
