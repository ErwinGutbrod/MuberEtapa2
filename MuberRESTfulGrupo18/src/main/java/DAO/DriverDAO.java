package DAO;

import java.util.List;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;

public interface DriverDAO extends GenericDAO<Driver, Integer> {
	List<Driver> getAllDrivers() throws Exception;
	String getDriverInformation(Driver driver) throws Exception;
}
