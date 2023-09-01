package testmaven.bandesal.gob.sv.repository;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import testmaven.bandesal.gob.sv.models.Usuario;

@Repository
public class UserDaoImpl implements UserDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Usuario getUserByName(String usuario) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			return session.createQuery("FROM Usuario us JOIN FETCH us.rol WHERE us.usuario = :usuario", Usuario.class)
					.setParameter("usuario", usuario).getSingleResult();
		} catch (Exception e) {

			return null;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
				session = null;
			}
		}
	}

	@Override
	public List<Usuario> getAll() {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			return session.createQuery("FROM Usuario us JOIN FETCH us.rol", Usuario.class).getResultList();
		} catch (Exception e) {
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
				session = null;
			}
		}

	}

	@Override
	public Usuario login(Usuario usuario) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			return session.createQuery(
					"FROM Usuario us JOIN FETCH us.rol rl WHERE us.usuario = :usuario AND us.contrasenia = :contrasenia",
					Usuario.class).setParameter("usuario", usuario.getUsuario())
					.setParameter("contrasenia", usuario.getContrasenia()).getSingleResult();
		} catch (Exception e) {
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
				session = null;
			}
		}
	}

}
