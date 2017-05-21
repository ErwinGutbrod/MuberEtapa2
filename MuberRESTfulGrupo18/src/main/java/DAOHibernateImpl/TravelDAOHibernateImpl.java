package DAOHibernateImpl;

import java.util.List;

import DAO.TravelDAO;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Travel;

public class TravelDAOHibernateImpl extends GenericDAOHibernateImpl<Travel, Integer> implements TravelDAO {

	@Override
	public List<Travel> getAllOpenTravels() throws Exception {
		// TODO Auto-generated method stub
		return null;
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
