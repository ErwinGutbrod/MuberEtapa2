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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EndTravel(Travel travel) {
		// TODO Auto-generated method stub
		
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
	
	private void PersistObject (SessionFactory sf,Object o){
		Session session = sf.getCurrentSession();
		try{
			session.beginTransaction();
			session.save(o);
			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	@Override
	public Driver getDriver(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTravelFinaliced(int idTravel) throws Exception {
		// TODO Auto-generated method stub
		return muber.isTravelFinaliced(idTravel);
	}

	@Override
	public void addReview(Review review) {
		// TODO Auto-generated method stub
		
	}

}
