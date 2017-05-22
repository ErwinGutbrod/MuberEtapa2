package bd2.web.service;

import java.util.List;

import javax.transaction.Transactional;

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
	public List<Passenger> getPassengers() {
		return muber.getPassengers();
	}

	@Override
	public List<Travel> getOpenTravels() {
		return muber.getOpenTravels();
	}

	@Override
	public Driver getDriver(int id) {
		return muber.getDriver(id);
	}

	@Override
	public boolean idTravelFinaliced(int idTravel) throws Exception {
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

	@Override
	public List<Driver> getTop10Drivers() {
		return muber.getTop10Drivers();
	}

}
