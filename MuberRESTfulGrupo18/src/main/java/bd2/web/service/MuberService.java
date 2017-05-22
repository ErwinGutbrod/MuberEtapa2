package bd2.web.service;

import java.util.List;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Review;
import bd2.Muber.model.Travel;

public interface MuberService {

	//Driver
	public void AddDriver(Driver driver);
	public Driver getDriver(int id);
	public List<Driver> getDrivers();
	public List<Driver> getTop10Drivers();
	
	//Travel
	public void AddTravel(Travel travel);
	public Travel getTravel(int id);
	public List<Travel> getOpenTravels();	
	public void AddPassengerToTravel(Travel travel, Passenger passenger1);
	public List<Travel> getTravelsFromDriver(Driver driver);
	public void endTravel(Travel travel);
	public boolean isTravelFinalized(int idTravel) throws Exception;
	//Review
	public void addReview(Review review);
	public List<Review> getReviewsFromDriver(Driver driver);
	
	//Passengers
	public void AddPassenger(Passenger passenger);
	public List<Passenger> getPassengers();
	public Passenger getPassenger(int idPassenger);
	public boolean updatePassenger(Passenger aPassenger);
	
}
