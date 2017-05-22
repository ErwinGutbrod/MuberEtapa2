package DAO;

import java.util.List;

import bd2.Muber.model.Driver;

public interface DriverDAO extends GenericDAO<Driver, Integer> {
	List<Driver> getAllDrivers() throws Exception;
	List<Driver> getTop10Drivers()throws Exception;
}
