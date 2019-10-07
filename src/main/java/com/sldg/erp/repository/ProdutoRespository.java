package com.sldg.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.sldg.erp.model.Product;

public class ProdutoRespository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;	
	
	public Product guardar(Product produto) {
		return this.manager.merge(produto);
	}
	
	public List<Product> listaProduto() {
		Session session = (Session) this.manager.getDelegate();
		Criteria criteria = session.createCriteria(Product.class);
		return criteria.list();
	}
	
	public List<Product> pesquisaProdutos(Product produto) {
		Session session = (Session) this.manager.getDelegate();
		Criteria criteria = session.createCriteria(Product.class);
		criteria.add(Restrictions.ilike("nomeProduto", produto.getNomeProduto(), MatchMode.ANYWHERE));
		criteria.add(Restrictions.ilike("marcaProduto", produto.getMarcaProduto(), MatchMode.ANYWHERE));
		return criteria.list();
	}

}
