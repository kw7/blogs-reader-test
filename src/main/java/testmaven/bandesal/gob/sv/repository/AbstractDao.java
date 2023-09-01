package testmaven.bandesal.gob.sv.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao <PK extends Serializable, T>{
    
	private final Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	public void persist(T entity) {
		getSession().persist(entity);
	}

	public void update(T entity) {
		getSession().saveOrUpdate(entity);
	}
	public void merge(T entity) {
		getSession().merge(entity);
	}
	public void delete(T entity) {
		getSession().delete(entity);
	}
	public List<T> selectAll(){
		List<T> entities;
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(persistentClass);
		Root<T> root = criteriaQuery.from(persistentClass);
		try{
		criteriaQuery.select(root);
		Query<T> query = getSession().createQuery(criteriaQuery);
		entities = query.getResultList();
		}catch(Exception e){
			e.printStackTrace();
			entities = null;
		}
		return entities;
	}
	public T selectEntityWhere(String columnName,String value){
		T entity;
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(persistentClass);
		Root<T> root = criteriaQuery.from(persistentClass);
		try{
		criteriaQuery.select(root).where(builder.equal(root.get(columnName),value));
		Query<T> query = getSession().createQuery(criteriaQuery);
		entity = query.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
			entity = null;
		}
		return entity;
	}
	protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }

}

