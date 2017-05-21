package bd2.Muber;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import DAO.DriverDAO;
import DAO.PassengerDAO;
import DAO.ReviewDAO;
import DAO.TravelDAO;
import DAOHibernateImpl.DriverDAOHibernateImpl;
import DAOHibernateImpl.PassengerDAOHibernateImpl;
import DAOHibernateImpl.ReviewDAOHibernateImpl;
import DAOHibernateImpl.TravelDAOHibernateImpl;
import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Review;
import bd2.Muber.model.Travel;

public class Muber {
	
	//DAOs
	protected DriverDAO DAODriver;
	protected PassengerDAO DAOPassenger;
	protected TravelDAO DAOTravel;
	protected ReviewDAO DAOReview;

	//Constructor
	
	public Muber(){
		super();
		//Initialize daos;
		DAODriver = new DriverDAOHibernateImpl();
		DAOPassenger = new PassengerDAOHibernateImpl();
		DAOTravel = new TravelDAOHibernateImpl();
		DAOReview = new ReviewDAOHibernateImpl();
	}
	
	//Methods
	public void AddDriver(Driver driver) {
		try {
			this.DAODriver.save(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void AddTravel(Travel travel) {
		try {
			this.DAOTravel.save(travel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void AddPassenger(Passenger passenger) {
		try {
			this.DAOPassenger.save(passenger);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void AddPassengerToTravel(Travel travel, Passenger passenger1) {

	}

	public void EndTravel(Travel travel) {
		
	}

	public void AddReviewTravel(Review review) {
		
	}
	
	public void PersistObject (SessionFactory sf,Object o){
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
		session.cancelQuery();
	}

	public List<Driver> getDrivers() {
		List<Driver> drivers = null;
		try {
			drivers = this.DAODriver.findAll(Driver.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return drivers;
	}

	public void setDrivers(ArrayList<Driver> drivers) {
	}

	public List<Passenger> getPassengers() {
		List<Passenger> passengers = null;
		try {
			passengers = this.DAOPassenger.findAll(Passenger.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return passengers;
	}

	public void setPassengers(ArrayList<Passenger> passengers) {
	}

	public List<Travel> getOpenTravels() {
		List<Travel> travels = null;
		try {
			travels = this.DAOTravel.getAllOpenTravels();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return travels;
	}

	public void setTravels(ArrayList<Travel> travels) {
	}

	public ArrayList<Review> getReviews() {
		return null;
	}

	public void setReviews(ArrayList<Review> reviews) {
	}

	public Driver getDriver(int id){
		Driver driver = null;
		try {
			driver = this.getDriver(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

	
}
