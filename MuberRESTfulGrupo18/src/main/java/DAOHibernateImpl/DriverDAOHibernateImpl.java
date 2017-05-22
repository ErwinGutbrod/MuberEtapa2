package DAOHibernateImpl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import DAO.DriverDAO;
import bd2.Muber.model.Driver;

public class DriverDAOHibernateImpl extends GenericDAOHibernateImpl<Driver, Integer> implements DriverDAO {

	@Override
	public List<Driver> getAllDrivers() throws Exception {
		List<Driver> drivers = this.findAll(Driver.class);
		return drivers;
	}

	@Override
	public List<Driver> getTop10Drivers() throws Exception {
		final Session session = sessionFactory.getCurrentSession();
		final Transaction trans = session.beginTransaction();
		String query = "SELECT  d.* FROM user_driver d LEFT JOIN travel t ON d.ID_USER = t.ID_USER INNER JOIN review r ON t.ID_TRAVEL = r.ID_TRAVEL WHERE d.ID_USER NOT IN(SELECT ID_USER FROM Travel WHERE IS_FINALISED = 0) AND t.ID_TRAVEL IS NOT NULL GROUP BY d.ID_USER ORDER BY SUM(r.RATE)/count(r.ID_REVIEW) DESC LIMIT 10";
		final SQLQuery sqlQuery = session.createSQLQuery(query);
		sqlQuery.addEntity("d", Driver.class);
	    List<Driver> list = (List<Driver>) sqlQuery.list();
	    trans.commit();
	    return list;
	}

}
