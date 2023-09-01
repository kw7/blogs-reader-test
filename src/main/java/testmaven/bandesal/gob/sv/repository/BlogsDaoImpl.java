package testmaven.bandesal.gob.sv.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import testmaven.bandesal.gob.sv.models.Blogs;
import testmaven.bandesal.gob.sv.models.Usuario;

//@Stateless
@Repository
public class BlogsDaoImpl implements BlogsDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Blogs> getAll() {
		Session session = null;
		List<Blogs> listBlogs=new ArrayList<Blogs>();
		try {
			System.out.print("iniciando");
			session = sessionFactory.openSession();
			listBlogs=session.createQuery("FROM Blogs bl", Blogs.class).getResultList();
			System.out.print("retornando");
			return listBlogs;
		} catch (Exception e) {
			System.out.print("error");
			return listBlogs;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
				session = null;
			}
		}
	}

	@Override
	public void save(Blogs model) {
		Session session = null;
		Transaction tx = null;

		try {

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
	public void update(Blogs model) {
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
	public void delete(Blogs model) {
		Session session = null;
		Transaction tx = null;

		try {

			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			//Blogs b = session.load(Blogs.class, model.getId());
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

	@Override
	public Blogs findBlog(Long id) {
		Session session = null;
		Blogs blog=new Blogs();
		try {
			System.out.print("iniciando");
			session = sessionFactory.openSession();
			blog=session.find(Blogs.class, id);
			System.out.print("retornando");
			return blog=session.createQuery("FROM Blogs bl WHERE bl.id = :id", Blogs.class)
					.setParameter("id", id).getSingleResult();
		} catch (Exception e) {
			System.out.print("error");
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
				session = null;
			}
		}
	}

}
