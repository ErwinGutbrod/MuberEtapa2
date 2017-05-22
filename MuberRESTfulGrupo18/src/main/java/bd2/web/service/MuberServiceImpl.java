package bd2.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import bd2.Muber.Muber;
import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Review;
import bd2.Muber.model.Travel;
@Service("muberService")
@Transactional
public class MuberServiceImpl implements MuberService{

	private Muber muber = new Muber();
	@Override
	public void AddDriver(Driver driver) {
		this.muber.AddDriver(driver);
	}

	@Override
	public void AddTravel(Travel travel) {
		this.muber.AddTravel(travel);
	}

	@Override
	public void AddPassenger(Passenger passenger) {
		this.muber.AddPassenger(passenger);
	}

	@Override
	public void AddPassengerToTravel(Travel travel, Passenger passenger1) {
		this.muber.AddPassengerToTravel(travel, passenger1);

	}

	@Override
	public void endTravel(Travel travel) {
		this.muber.endTravel(travel);
		
	}

	@Override
	public List<Driver> getDrivers() {
		return muber.getDrivers();
	}

	@Override
	public void setDrivers(ArrayList<Driver> drivers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Passenger> getPassengers() {
		return muber.getPassengers();
	}

	@Override
	public void setPassengers(ArrayList<Passenger> passengers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Travel> getOpenTravels() {
		return muber.getOpenTravels();
	}

	@Override
	public void setTravels(ArrayList<Travel> travels) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Review> getReviews() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReviews(ArrayList<Review> reviews) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Driver getDriver(int id) {
		return muber.getDriver(id);
	}

	@Override
	public boolean idTravelFinaliced(int idTravel) throws Exception {
		// TODO Auto-generated method stub
		return muber.isTravelFinaliced(idTravel);
	}

	@Override
	public void addReview(Review review) {
		 muber.addReviwe(review);
	}

	@Override
	public List<Travel> getTravelsFromDriver(Driver driver) {
		return muber.getTravelsFromDriver(driver);
	}

	@Override
	public List<Review> getReviewsFromDriver(Driver driver) {
		return muber.getReviewsFromDriver(driver);
	}

//	@Override
//	public void AddReviewTravel(Review review) {
//		// TODO Auto-generated method stub
//		
//	}


	@Override
	public Passenger getPassenger(int idPassenger) {
		return this.muber.getPassenger(idPassenger);
	}

	@Override
	public boolean updatePassenger(Passenger aPassenger) {
		return this.muber.updatePassenger(aPassenger);
	}

	@Override
	public Travel getTravel(int idTravel) {
		return this.muber.getTravel(idTravel);
	}

}
