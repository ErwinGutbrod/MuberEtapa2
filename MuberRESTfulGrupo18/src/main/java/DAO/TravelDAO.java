package DAO;

import java.util.List;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Travel;

public interface TravelDAO extends GenericDAO<Travel, Integer> {
	List<Travel> getAllOpenTravels() throws Exception;
	List<Travel> getTravelsFromDriver(Driver driver) throws Exception;
	Travel endTravel(Travel travel) throws Exception;
}
