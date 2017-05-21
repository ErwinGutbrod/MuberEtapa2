package DAOHibernateImpl;

import java.util.List;

import DAO.DriverDAO;
import bd2.Muber.model.Driver;

public class DriverDAOHibernateImpl extends GenericDAOHibernateImpl<Driver, Integer> implements DriverDAO {

	@Override
	public List<Driver> getAllDrivers() throws Exception {
		List<Driver> drivers = this.findAll(Driver.class);
		return drivers;
	}

	@Override
	public String getDriverInformation(Driver driver) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
