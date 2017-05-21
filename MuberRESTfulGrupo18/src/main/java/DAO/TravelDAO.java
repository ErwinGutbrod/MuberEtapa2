package DAO;

import java.util.List;

import bd2.Muber.model.Passenger;
import bd2.Muber.model.Travel;

public interface TravelDAO extends GenericDAO<Travel, Integer> {
	List<Travel> getAllOpenTravels() throws Exception;
	Travel createTravel() throws Exception;
	Travel addPassengerToTravel(Travel travel,Passenger passenger) throws Exception;
	Travel endTravel(Travel travel);
}
