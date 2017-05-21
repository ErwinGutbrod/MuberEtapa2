package bd2.Muber.model;

public class Passenger  extends User{

	//Attributes
	private double credit;
	
	//Constructor
	public Passenger() {
		super();
	}
	
	//Getters & Setters
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	
}
