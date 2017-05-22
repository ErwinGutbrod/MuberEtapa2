package DAOHibernateImpl;

import java.util.List;

import DAO.PassengerDAO;
import bd2.Muber.model.Passenger;

public class PassengerDAOHibernateImpl extends GenericDAOHibernateImpl<Passenger, Integer> implements PassengerDAO {

	@Override
	public List<Passenger> getAllPassengers() throws Exception {
		List<Passenger> passengers = this.findAll(Passenger.class);
		return passengers;
	}

	

}
