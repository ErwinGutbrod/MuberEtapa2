package bd2.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.gson.Gson;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Review;
import bd2.Muber.model.Travel;
import bd2.web.service.MuberService;
import mapping.AgregarPasajero;
import mapping.CargarCredito;

@ControllerAdvice
@RequestMapping("/services")
@ResponseBody
@EnableWebMvc
public class MuberRestController {

	@Autowired
	MuberService muberService;  
	
	@RequestMapping(value = "/pasajeros", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String getPassengers() {
		
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		aMap.put("pasajeros", muberService.getPassengers());

		return new Gson().toJson(aMap);
	}
	
	@RequestMapping(value = "/conductores", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String getDrivers() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		aMap.put("conductores", muberService.getDrivers());
		return new Gson().toJson(aMap);
	}
	
	@RequestMapping(value = "/viajes/abiertos", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String getTravelOpened() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		aMap.put("viajes", muberService.getOpenTravels());
		return new Gson().toJson(aMap);
	}
	

	@RequestMapping(value = "/conductores/detalle", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String getDriverDetail(
			@RequestParam(value="conductorId", required = true) String conductorId) {
		Driver driver = muberService.getDriver(Integer.parseInt(conductorId));
		List<Travel> driverTravels = muberService.getTravelsFromDriver(driver);
		List<Review> driverReviews = muberService.getReviewsFromDriver(driver);
		int scoreSum = 0;
		int scoreCount = 0;
		double averageScore = 0;
		for (Iterator<Review> i = driverReviews.iterator(); i.hasNext();) {
		    Review item = i.next();
		    scoreSum+=item.getRate();
		    scoreCount++;
		}
		averageScore = scoreSum/scoreCount;
		
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		aMap.put("userName", driver.getName());
		aMap.put("driverTravels", driverTravels);
		aMap.put("averageScore", averageScore);
		aMap.put("licenseExpiration", driver.getLicenseExpirationDate());
		return new Gson().toJson(aMap);
	}

	@RequestMapping(value = "/pasajero/nuevo", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String getNewPassenger(
			@RequestParam(value="name", required = true) String name,
			@RequestParam(value="password", required = true) String password,
			@RequestParam(value="credit", required = true) String credit) {
		Passenger passenger = new Passenger();
		passenger.setName(name);
		passenger.setPassword(password);
		passenger.setStartDate(Calendar.getInstance());
		passenger.setCredit(Double.parseDouble(credit));
		muberService.AddPassenger(passenger);
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}
	

	@RequestMapping(value = "/viajes/nuevo", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String getNewTravel(
			@RequestParam(value="origen", required = true) String origen,
			@RequestParam(value="destino", required = true) String destino,
			@RequestParam(value="conductorId", required = true) String conductorId,
			@RequestParam(value="costoTotal", required = true) String costoTotal,
			@RequestParam(value="cantidadPasajeros", required = true) String cantidadPasajeros) {
		
		Driver driver = muberService.getDriver(Integer.parseInt(conductorId));
	
		Travel aTravel = new Travel();
		
		aTravel.setOrigin(origen);
		aTravel.setDestination(destino);
		aTravel.setDriver(driver);
		aTravel.setDate(Calendar.getInstance());
		aTravel.setTotalAmount(Double.parseDouble(costoTotal));
		aTravel.setPassengerCount(Integer.parseInt(cantidadPasajeros));
		
		muberService.AddTravel(aTravel);
		
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}


	@RequestMapping(value = "/viajes/agregarPasajero", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public @ResponseBody String addPassengerInTravel(@RequestBody AgregarPasajero unaInsancia) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}
	

	
	///////****************************************************************
	@RequestMapping(value = "/viajes/calificar", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String rateToTravel(
			@RequestParam(value="viajeId", required = true) String viajeId,
			@RequestParam(value="pasajeroId", required = true) String pasajeroId,
			@RequestParam(value="puntaje", required = true) String puntaje,
			@RequestParam(value="comentario", required = true) String comentario) throws NumberFormatException, Exception {
		Map<String, Object> aMap = new HashMap<String, Object>();
		
		if(muberService.idTravelFinaliced(Integer.parseInt(viajeId))){
			Review aReview = new Review();
			aReview.setRate(Integer.parseInt(puntaje));
			aReview.setReview(comentario);		
			
			Passenger aPassenger = muberService.getPassenger(Integer.parseInt(pasajeroId));
				
			Travel travel = muberService.getTravel(Integer.parseInt(viajeId));
			aReview.setTravel(travel);
			aReview.setPassenger(aPassenger);
			
			muberService.addReview(aReview);
			aMap.put("result", "OK");
		}else{
			aMap.put("result", "fail");
		}
		
		

		return new Gson().toJson(aMap);
	}
	
	@RequestMapping(value = "/pasajeros/cargarCredito", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public String insertCredit(@RequestBody CargarCredito cargarCredito) {
				
		Passenger aPassenger = new Passenger();
		aPassenger.setIdUser(cargarCredito.getPasajeroId());
		aPassenger.setCredit(cargarCredito.getMonto());
		
		Map<String, Object> aMap = new HashMap<String, Object>();

		if (this.muberService.updatePassenger(aPassenger)){
			aMap.put("result", "OK");
		}else{
			aMap.put("result", "fail");
		}
		return new Gson().toJson(aMap);
	}	
	
	
	@RequestMapping(value = "/viajes/finalizar", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public @ResponseBody String finishTravel(@RequestBody String viajeId) throws NumberFormatException, Exception {
		// Corroborarar que se finalice una vez
		Map<String, Object> aMap = new HashMap<String, Object>();

		Travel travel = muberService.getTravel(Integer.parseInt(viajeId));

		if(!muberService.idTravelFinaliced(Integer.parseInt(viajeId))){
			muberService.endTravel(travel);
			aMap.put("result", "OK");
		}else{
			aMap.put("result", "fail");

		}

		return new Gson().toJson(aMap);
	}		
//	
//	@RequestMapping(value = "/conductores/top10", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
//	public String topTenOfDrivers() {
//		// Listar los 10 conductores mejor calificados que no tengan viajes abiertos registrad
//		Map<String, Object> aMap = new HashMap<String, Object>();
//		aMap.put("result", "OK"); 
//		return new Gson().toJson(aMap);
//	}	
}

