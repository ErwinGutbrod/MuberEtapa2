package bd2.Muber;


import java.util.List;
import java.util.Set;


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
	//Driver
	public void AddDriver(Driver driver) {
		try {
			this.DAODriver.save(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Driver getDriver(int id){
		Driver driver = null;
		try {
			driver = this.DAODriver.get(Driver.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	public List<Driver> getDrivers() {
		List<Driver> drivers = null;
		try {
			drivers = this.DAODriver.findAll(Driver.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return drivers;
	}
	
	public List<Driver> getTop10Drivers() {
		List<Driver> drivers = null;
		try {
			drivers = this.DAODriver.getTop10Drivers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return drivers;
	}
	
	
	//Passenger
	
	public void AddPassenger(Passenger passenger) {
		try {
			this.DAOPassenger.save(passenger);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Passenger getPassenger(int idPassenger){
		Passenger aPassenger = new Passenger();
		try {
			aPassenger = this.DAOPassenger.get(Passenger.class, idPassenger);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aPassenger;
	}
	
	public boolean updatePassenger(Passenger aPassenger){
		try {
				Passenger passenger = this.getPassenger(aPassenger.getIdUser());
				if (passenger != null){
					passenger.setCredit(passenger.getCredit() + aPassenger.getCredit());
					this.DAOPassenger.saveOrUpdate(passenger);
					return true;
				}
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
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
	
	//Travel

	public void AddTravel(Travel travel) {
		try {
			this.DAOTravel.save(travel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Travel getTravel(int idTravel){
		Travel aTravel = new Travel();
		try {
			aTravel = this.DAOTravel.get(Travel.class, idTravel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aTravel;
	}

	public void AddPassengerToTravel(Travel travel, Passenger passenger1) {
		travel.getPassengers().add(passenger1);
		try {
			this.DAOTravel.saveOrUpdate(travel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void endTravel(Travel travel) {
		try {
			this.DAOTravel.endTravel(travel);
			Set<Passenger> passengers = travel.getPassengers();

			double amount = travel.getTotalAmount() / passengers.size();
			
			for (Passenger p : passengers) {
				p.setCredit(amount * -1);
			    this.updatePassenger(p);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public List<Travel> getTravelsFromDriver(Driver driver){
		List<Travel> travels = null;
		try {
			travels = this.DAOTravel.getTravelsFromDriver(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return travels;
	}
	
	public boolean isTravelFinalized(int id) throws Exception{
		Travel travel = this.DAOTravel.get(Travel.class, id);
				if (travel != null){
						return travel.getIsFinalised();
					}else{
						return false;
					}
		}
	
	//Review

	public void addReview(Review review) {
		try {
			this.DAOReview.save(review);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public List<Review> getReviewsFromDriver(Driver driver){
		List<Review> reviews = null;
		try {
			reviews = this.DAOReview.getReviewsFromDriver(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reviews;
	}


	
	
}
