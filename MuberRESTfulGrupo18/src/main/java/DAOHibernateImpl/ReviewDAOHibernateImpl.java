package DAOHibernateImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import DAO.ReviewDAO;
import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Review;
import bd2.Muber.model.Travel;

public class ReviewDAOHibernateImpl extends GenericDAOHibernateImpl<Review, Integer> implements ReviewDAO {

	@Override
	public Review createReview(Travel travel, Passenger passenger) {
		// TODO Auto-generated method stub
		return null;
	}


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
