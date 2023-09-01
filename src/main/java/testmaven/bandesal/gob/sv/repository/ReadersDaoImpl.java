package testmaven.bandesal.gob.sv.repository;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import testmaven.bandesal.gob.sv.models.Blogs;
import testmaven.bandesal.gob.sv.models.Readers;

//@Stateless
@Repository
public class ReadersDaoImpl implements ReadersDao {

	@Autowired
	SessionFactory sessionFactory; 
	
	@Override
	public List<Readers> getAll() {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			return session.createQuery("FROM Readers rd", Readers.class).getResultList();
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
	public void save(Readers model) {
		Session session = null;
		Transaction tx = null;

		try {
			System.out.print("iniciando reader");
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.persist(model);
			tx.commit();

		} catch (Exception e) {			
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
				session = null;
			}
		}
		
	}

	@Override
	public void update(Readers model) {
		Session session = null;
		Transaction tx = null;

		try {

			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(model);
			tx.commit();

		} catch (Exception e) {			
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
				session = null;
			}
		}
		
	}

	@Override
	public void delete(Readers model) {
		Session session = null;
		Transaction tx = null;

		try {

			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			//Readers b = session.load(Readers.class, model.getId());
			session.delete(model);
			tx.commit();

		} catch (Exception e) {			
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
				session = null;
			}
		}
		
	}

}
