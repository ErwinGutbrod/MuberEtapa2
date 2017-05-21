package bd2.Muber;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Review;
import bd2.Muber.model.Travel;

public class Muber {

	public void AddDriver(Driver driver) {
		Configuration cfg = new Configuration().configure("/main/java/hibernate/hibernate.cfg.xml");
		SessionFactory sessionFactory= cfg.buildSessionFactory();
		PersistObject(sessionFactory,driver);
		sessionFactory.close();
	}

	public void AddTravel(Travel travel) {
		Configuration cfg = new Configuration().configure("/main/java/hibernate/hibernate.cfg.xml");
		SessionFactory sessionFactory= cfg.buildSessionFactory();
		PersistObject(sessionFactory,travel);
	}

	public void AddPassenger(Passenger passenger) {
		Configuration cfg = new Configuration().configure("/main/java/hibernate/hibernate.cfg.xml");
		SessionFactory sessionFactory= cfg.buildSessionFactory();
		PersistObject(sessionFactory,passenger);
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

	public ArrayList<Driver> getDrivers() {
		return null;
	}

	public void setDrivers(ArrayList<Driver> drivers) {
	}

	public ArrayList<Passenger> getPassengers() {
		return null;
	}

	public void setPassengers(ArrayList<Passenger> passengers) {
	}

	public ArrayList<Travel> getTravels() {
		return null;
	}

	public void setTravels(ArrayList<Travel> travels) {
	}

	public ArrayList<Review> getReviews() {
		return null;
	}

	public void setReviews(ArrayList<Review> reviews) {
	}



	
}
