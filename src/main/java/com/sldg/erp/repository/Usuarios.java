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

import com.sldg.erp.model.Usuario;

/**
 * @author DaniloGessica
 *
 */
/**
 * @author DaniloGessica
 *
 */
public class Usuarios implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("SistemaLanchesDaniloGessica");
	
	EntityManager manger2 = factory.createEntityManager();
	
	/**
	 * 
	 * Metodo que retorna o codigo do usuario
	 * @param codigo
	 * @return
	 */
	public Usuario porCodigo(Long codigo) {
		return manager.find(Usuario.class, codigo);
	}
	
	public Usuario autenticaUsuario(Usuario usuario) {
		Query query = manager.createQuery("from Usuario u where u.email = :pemail and u.senha = :pcodigo");
		query.setParameter("pemail", usuario.getEmail());
		query.setParameter("pcodigo", usuario.getSenha());
		return (Usuario) query.getResultList();
	}
	
	/**
	 * Método responsável por verificar se existe usuario e senha para autenticação
	 * @param usuario
	 * @return
	 */
	public Usuario autentica(Usuario usuario) {
		Session session = (Session) manager.getDelegate();
		Criteria criteria = session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("email", usuario.getEmail()));
		criteria.add(Restrictions.eq("senha", usuario.getSenha()));
		return (Usuario) criteria.uniqueResult();
	}
	
	public Usuario autenticar(final String user, final String senha) {
		manger2.getTransaction().begin();
		Query query = manger2.createQuery("from Usuario u where u.email = :pemail and u.senha = :pcodigo");
		query.setParameter("pemail", user);
		query.setParameter("pcodigo", senha);
		
		return (Usuario) query.getSingleResult();
		
	}

	public Usuario guardar(Usuario usuario) {
		return manager.merge(usuario);
	}
	
	public List<Usuario> listaUsuario() {
		Query query = manager.createQuery("from Usuario", Usuario.class);
		return query.getResultList();
	}
	
	public List<Usuario> pesquisaUsuarios(Usuario usuario) {

		Query query = manager.createQuery("from Usuario where email = :pemail and codigo = :pcodigo");

		query.setParameter("pemail", usuario.getEmail());
		query.setParameter("pcodigo", usuario.getCodigo());
		List<Usuario> usuarios = query.getResultList();
		
		return usuarios;
	}

}



