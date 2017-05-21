package DAOHibernateImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import DAO.TravelDAO;
import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Travel;

public class TravelDAOHibernateImpl extends GenericDAOHibernateImpl<Travel, Integer> implements TravelDAO {

	public List<Travel> getAllOpenTravels() throws Exception {
		final Session session = sessionFactory.getCurrentSession();
		final Transaction trans = session.beginTransaction();
	    final Criteria crit = session.createCriteria(Travel.class);
	    crit.add(Expression.eq("isFinalised",false));
	    List<Travel> list = (List<Travel>) crit.list();
	    trans.commit();
	    return list;
	}
	
	public List<Travel> getTravelsFromDriver(Driver driver) throws Exception {
		final Session session = sessionFactory.getCurrentSession();
		final Transaction trans = session.beginTransaction();
	    final Criteria crit = session.createCriteria(Travel.class);
	    crit.add(Expression.eq("driver",driver));
	    List<Travel> list = (List<Travel>) crit.list();
	    trans.commit();
	    return list;
	}

	@Override
	public Travel createTravel() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Travel addPassengerToTravel(Travel travel, Passenger passenger) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Travel endTravel(Travel travel) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
