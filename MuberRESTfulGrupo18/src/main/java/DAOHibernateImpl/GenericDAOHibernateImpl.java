package DAOHibernateImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import DAO.GenericDAO;

public class GenericDAOHibernateImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	SessionFactory sessionFactory;
	
	public GenericDAOHibernateImpl() {
		Configuration cfg = new Configuration().configure("/main/java/hibernate/hibernate.cfg.xml");
		sessionFactory= cfg.buildSessionFactory();
	}
	
	public T create() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveOrUpdate(T entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public T get(ID id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(ID id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<T> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
