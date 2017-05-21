package DAOHibernateImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import DAO.GenericDAO;

public class GenericDAOHibernateImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

protected static SessionFactory sessionFactory;
	
	public GenericDAOHibernateImpl() {
		if(sessionFactory == null){
		Configuration cfg = new Configuration().configure("/resources/hibernate.cfg.xml");
		sessionFactory= cfg.buildSessionFactory();
		}		
	}
	
	public T save(T entity) throws Exception {
		final Session session = sessionFactory.getCurrentSession();
		final Transaction trans = session.beginTransaction();
		T entitySaved = (T)session.save(entity);
		trans.commit();
		return entitySaved; 
	}

	public void saveOrUpdate(T entity) throws Exception {
		final Session session = sessionFactory.getCurrentSession();
		final Transaction trans = session.beginTransaction();
		session.saveOrUpdate(entity);
		trans.commit();
		
	}

	public T get(Class<T> type,ID id) throws Exception {
		final Session session = sessionFactory.getCurrentSession();
		final Transaction trans = session.beginTransaction();
		T entity = (T)session.get(type, id);
		trans.commit();
		return entity;
	}

	public void delete(T entity) throws Exception {
		final Session session = sessionFactory.getCurrentSession();
		final Transaction trans = session.beginTransaction();
		session.delete(entity);
		trans.commit();		
	}

	public List<T> findAll(Class<T> type) throws Exception {
		final Session session = sessionFactory.getCurrentSession();
		final Transaction trans = session.beginTransaction();
	    final Criteria crit = session.createCriteria(type);
	    List<T> list = crit.list();
	    trans.commit();
	    return list;
	}


}
