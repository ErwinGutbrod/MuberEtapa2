package bd2.web.service;

import java.util.ArrayList;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Review;
import bd2.Muber.model.Travel;

public interface MuberService {

	public void AddDriver(Driver driver);
	public void AddTravel(Travel travel);
	public void AddPassenger(Passenger passenger);
	public void AddPassengerToTravel(Travel travel, Passenger passenger1);
	public void EndTravel(Travel travel);
	public void AddReviewTravel(Review review);
	public ArrayList<Driver> getDrivers();
	public void setDrivers(ArrayList<Driver> drivers);
	public ArrayList<Passenger> getPassengers();
	public void setPassengers(ArrayList<Passenger> passengers);
	public ArrayList<Travel> getTravels();
	public void setTravels(ArrayList<Travel> travels);
	public ArrayList<Review> getReviews();
	public void setReviews(ArrayList<Review> reviews);
	
	
	
	
}
