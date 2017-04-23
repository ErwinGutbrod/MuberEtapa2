package bd2.Muber.model;

public class Passenger  extends User{

	//Attributes
	private long credit;
	
	//Constructor
	public Passenger() {
		super();
	}
	
	//Getters & Setters
	public long getCredit() {
		return credit;
	}
	public void setCredit(long credit) {
		this.credit = credit;
	}
	
}
