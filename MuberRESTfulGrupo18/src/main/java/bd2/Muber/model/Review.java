package bd2.Muber.model;

public class Review {

	//Attributes
	private int idReview;
	private int rate;
	private Passenger passenger;
	private String review;
	private Travel travel;
	
	//Constructor
	public Review() {
		super();
	}

	//Getters & Setters
	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}

	public int getIdReview() {
		return idReview;
	}

	public void setIdReview(int idReview) {
		this.idReview = idReview;
	}
	
	
	
	
}
