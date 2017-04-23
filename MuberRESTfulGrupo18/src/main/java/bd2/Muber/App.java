package bd2.Muber;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import bd2.Muber.model.*;

public class App {

	public static void main(String[] args) {
		Muber muber = new Muber();
		
		//Instancio un conductor que se llame Roberto
		Driver driver = new Driver();
		driver.setName("Roberto");
		driver.setPassword("rob123");
		Calendar driverStartDate = Calendar.getInstance();
		Calendar driverLicenseExpirationDate = Calendar.getInstance();
		driver.setStartDate(driverStartDate);		
		driverLicenseExpirationDate.add(Calendar.YEAR, 2);
		driver.setLicenseExpirationDate(driverLicenseExpirationDate);
		driver.setIdUser(1);
		
		muber.AddDriver(driver);
		
		//Roberto crea un viaje de La Plata a Tres arroyos para 4 pasajeros, costo total $900
		Calendar travelDate = Calendar.getInstance();
		travelDate.add(Calendar.DAY_OF_MONTH, 3);
		Travel travel = new Travel();
		travel.setDate(travelDate);
		travel.setOrigin("La Plata");
		travel.setDestination("Tres Arroyos");
		travel.setPassengerCount(4);
		travel.setIsFinalised(false);
		travel.setDriver(driver);
		travel.setIdTravel(1);
		travel.setTotalAmount(900);
		travel.setPassengers(new HashSet<Passenger>());
		muber.AddTravel(travel);
		
		//Creo los pasajeros German, Alicia y Margarita
		Calendar passenger1StartDate = Calendar.getInstance();
		Passenger passenger1 = new Passenger();
		passenger1.setIdUser(2);
		passenger1.setName("Germán");
		passenger1.setPassword("ger123");
		passenger1.setStartDate(passenger1StartDate);
		passenger1.setCredit(1500);
		muber.AddPassenger(passenger1);
		
		Calendar passenger2StartDate = Calendar.getInstance();
		Passenger passenger2 = new Passenger();
		passenger2.setIdUser(3);
		passenger2.setName("Alicia");
		passenger2.setPassword("ali123");
		passenger2.setStartDate(passenger2StartDate);
		passenger2.setCredit(1500);
		muber.AddPassenger(passenger2);
		
		Calendar passenger3StartDate = Calendar.getInstance();
		Passenger passenger3 = new Passenger();
		passenger3.setIdUser(4);
		passenger3.setName("Margarita");
		passenger3.setPassword("marg123");
		passenger3.setStartDate(passenger3StartDate);
		passenger3.setCredit(1500);
		muber.AddPassenger(passenger3);
		
		//Agrego los pasajeros al viaje
		muber.AddPassengerToTravel(travel,passenger1);
		muber.AddPassengerToTravel(travel,passenger2);
		muber.AddPassengerToTravel(travel,passenger3);
		
		//Finalizo el viaje, se le descuentan los creditos a los pasajeros
		muber.EndTravel(travel);
		
		//Los pasajeros califican el viaje
		Review review1 = new Review();
		review1.setIdReview(1);
		review1.setTravel(travel);
		review1.setPassenger(passenger1);
		review1.setRate(5);
		review1.setReview("Fue un excelente viaje, lo pase fenomenal, Roberto es un excelente conductor");
		muber.AddReviewTravel(review1);
		
		Review review2 = new Review();
		review2.setIdReview(2);
		review2.setTravel(travel);
		review2.setPassenger(passenger2);
		review2.setRate(4);
		review2.setReview("El viaje fue bueno, pero Roberto es muy callado, me aburrí un poco");
		muber.AddReviewTravel(review2);
		
		Review review3 = new Review();
		review3.setIdReview(3);
		review3.setTravel(travel);
		review3.setPassenger(passenger3);
		review3.setRate(4);
		review3.setReview("Me gusto el viaje, pero Roberto no quiso prender la calefaccion, tuve frío");
		muber.AddReviewTravel(review3);
		
		//Persisto los cambios en la Base de datos
		muber.SaveChanges();
		
	}

}
