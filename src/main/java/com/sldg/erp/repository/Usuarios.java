package com.sldg.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.sldg.erp.model.User;

/**
 * @author DaniloGessica
 *
 */
/**
 * @author DaniloGessica
 *
 */
public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("SistemaLanchesDaniloGessica");
	
	EntityManager manger2 = factory.createEntityManager();
	
	public User porCodigo(Long codigo) {
		return manager.find(User.class, codigo);
	}
	
	public User autenticaUsuario(User usuario) {
		Query query = manager.createQuery("from User u where u.email = :pemail and u.senha = :pcodigo");
		query.setParameter("pemail", usuario.getEmail().trim());
		query.setParameter("pcodigo", usuario.getSenha().trim());
		return (User) query.getResultList();
	}
	
	/**
	 * Método responsável por verificar se existe usuario e senha para autenticação
	 * @param usuario
	 * @return
	 */
	public User autentica(User usuario) {
		Session session = (Session) manager.getDelegate();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("email", usuario.getEmail().trim()));
		criteria.add(Restrictions.eq("senha", usuario.getSenha().trim()));
		return (User) criteria.uniqueResult();
	}
	
	public User autenticar(final String user, final String senha) {
		manger2.getTransaction().begin();
		Query query = manger2.createQuery("from Usuario u where u.email = :pemail and u.senha = :pcodigo");
		query.setParameter("pemail", user);
		query.setParameter("pcodigo", senha);
		
		return (User) query.getSingleResult();
		
	}

	public User guardar(User usuario) {
		return manager.merge(usuario);
	}
	
	public List<User> listaUsuario() {
		Query query = manager.createQuery("from Usuario", User.class);
		return query.getResultList();
	}
	
	public List<User> pesquisaUsuarios(User usuario) {

		Query query = manager.createQuery("from Usuario where email = :pemail and codigo = :pcodigo");

		query.setParameter("pemail", usuario.getEmail());
		query.setParameter("pcodigo", usuario.getCodigo());
		List<User> usuarios = query.getResultList();
		
		return usuarios;
	}

}



