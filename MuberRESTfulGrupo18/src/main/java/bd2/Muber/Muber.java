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
	
	//Properties
	private ArrayList<Driver> drivers;
	private ArrayList<Passenger> passengers;
	private ArrayList<Travel> travels;
	private ArrayList<Review> reviews;
	
	//Constructor
	public Muber(){
		this.drivers = new ArrayList<Driver>();
		this.passengers = new ArrayList<Passenger>();
		this.travels = new ArrayList<Travel>();
		this.reviews = new ArrayList<Review>();
	}

	public void AddDriver(Driver driver) {
		this.drivers.add(driver);		
	}

	public void AddTravel(Travel travel) {
		this.travels.add(travel);		
	}

	public void AddPassenger(Passenger passenger) {
		this.passengers.add(passenger);		
	}

	public void AddPassengerToTravel(Travel travel, Passenger passenger1) {
		
		for(Travel tr : this.travels) { 
			   if(tr.getIdTravel() == travel.getIdTravel()) { 
				   if(tr.getPassengers().size() < tr.getPassengerCount()){
					   tr.getPassengers().add(passenger1);
				   }
			      
			   }
			}
		
	}

	public void EndTravel(Travel travel) {
		for(Travel tr : this.travels) { 
			   if(tr.getIdTravel() == travel.getIdTravel()) { 
			      tr.setIsFinalised(true);
			      for(Passenger passenger : tr.getPassengers()) { 
					   passenger.setCredit(passenger.getCredit() - (tr.getTotalAmount()/tr.getPassengers().size()));

					 
				  }
			   }
		}
		
	}

	public void AddReviewTravel(Review review) {
		this.reviews.add(review);
		
	}

	public void SaveChanges() {
		Configuration cfg = new Configuration().configure("/main/java/hibernate/hibernate.cfg.xml");
		SessionFactory sessionFactory= cfg.buildSessionFactory();
		
		for(Driver driver : this.drivers) {
			PersistObject(sessionFactory,driver);
		} 
		
		for(Passenger passenger : this.passengers) {
			PersistObject(sessionFactory,passenger);
		} 
		
		for(Travel travel : this.travels) {
			PersistObject(sessionFactory,travel);
		} 
		
		for(Review review : this.reviews) {
			PersistObject(sessionFactory,review);
		} 
		
		
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
	}



	
}
