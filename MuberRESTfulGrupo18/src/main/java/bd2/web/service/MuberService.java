package bd2.web.service;

import java.util.ArrayList;
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
	public void setDrivers(ArrayList<Driver> drivers);
	//Travel
	public void AddTravel(Travel travel);
	public Travel getTravel(int id);
	public List<Travel> getOpenTravels();
	public void AddPassenger(Passenger passenger);
	public void AddPassengerToTravel(Travel travel, Passenger passenger1);
	public List<Travel> getTravelsFromDriver(Driver driver);
	public void endTravel(Travel travel);
	public boolean idTravelFinaliced(int idTravel) throws Exception;
	//Review
	public void addReview(Review review);
	public ArrayList<Review> getReviews();
	public void setReviews(ArrayList<Review> reviews);
	public List<Review> getReviewsFromDriver(Driver driver);
	
	//Passengers
	public List<Passenger> getPassengers();
	public void setPassengers(ArrayList<Passenger> passengers);	
	public void setTravels(ArrayList<Travel> travels);
	public Passenger getPassenger(int idPassenger);
	public boolean updatePassenger(Passenger aPassenger);
	
}
