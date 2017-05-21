package DAO;

import java.util.List;

import bd2.Muber.model.Passenger;

public interface PassengerDAO extends GenericDAO<Passenger, Integer> {
	List<Passenger> getAllPassengers() throws Exception;
}
