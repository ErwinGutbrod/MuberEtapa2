package DAOHibernateImpl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import DAO.ReviewDAO;
import bd2.Muber.model.Driver;
import bd2.Muber.model.Review;


public class ReviewDAOHibernateImpl extends GenericDAOHibernateImpl<Review, Integer> implements ReviewDAO {

	public List<Review> getReviewsFromDriver(Driver driver) throws Exception {
		final Session session = sessionFactory.getCurrentSession();
		final Transaction trans = session.beginTransaction();
		String query = "SELECT r.* FROM Review r INNER JOIN Travel t ON r.ID_TRAVEL = t.ID_TRAVEL WHERE t.ID_USER =" + driver.getIdUser();
		final SQLQuery sqlQuery = session.createSQLQuery(query);
		sqlQuery.addEntity("r", Review.class);
	    List<Review> list = (List<Review>) sqlQuery.list();
	    trans.commit();
	    return list;
	}
	

}
