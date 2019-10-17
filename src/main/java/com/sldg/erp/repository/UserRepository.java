package com.sldg.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.sldg.erp.model.User;

public class UserRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public User findByCode(Long codigo) {
		return manager.find(User.class, codigo);
	}
		
	/*
	 * public User autenticaUsuario(User usuario) { Query query = manager.
	 * createQuery("from User u where u.email = :pemail and u.senha = :pcodigo");
	 * query.setParameter("pemail", usuario.getEmail().trim());
	 * query.setParameter("pcodigo", usuario.getSenha().trim()); return (User)
	 * query.getResultList(); }
	 */
	
	/*
	 * public User autentica(User usuario) { Session session = (Session)
	 * manager.getDelegate(); Criteria criteria =
	 * session.createCriteria(User.class); criteria.add(Restrictions.eq("email",
	 * usuario.getEmail().trim())); criteria.add(Restrictions.eq("senha",
	 * usuario.getSenha().trim())); return (User) criteria.uniqueResult(); }
	 */
	
	/*
	 * public User autenticar(final String user, final String senha) {
	 * manger2.getTransaction().begin(); Query query = manger2.
	 * createQuery("from User u where u.email = :pemail and u.senha = :pcodigo");
	 * query.setParameter("pemail", user); query.setParameter("pcodigo", senha);
	 * return (User) query.getSingleResult();
	 * 
	 * }
	 */

	public User save(User usuario) {
		return manager.merge(usuario);
	}
	
	public List<User> findAll() {
		Query query = manager.createQuery("from Usuario", User.class);
		return query.getResultList();
	}
	
}



