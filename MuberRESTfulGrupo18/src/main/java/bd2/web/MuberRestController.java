package bd2.web;

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
import bd2.Muber.model.Travel;
import bd2.web.service.MuberService;
import mapping.AgregarPasajero;

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
		// Obtener  la  información  de  un  conductor  (nombre  de  usuario, viajes  realizados,  puntaje promedio y fecha de licencia
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}
	
	@RequestMapping(value = "/pasajero/nuevo", method = RequestMethod.POST, produces = "application/json",consumes = "application/json", headers = "Accept=application/json")
	public String getNewPassenger(
			@RequestParam(value="name", required = true) String name,
			@RequestParam(value="password", required = true) String password,
			@RequestParam(value="startDate", required = true) String startDate,
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
		
		Driver driver = new Driver();
		driver.setIdUser(Integer.parseInt(conductorId));
		Travel aTravel = new Travel();
		
		aTravel.setOrigin(origen);
		aTravel.setDestination(destino);
		aTravel.setDriver(driver);
		aTravel.setTotalAmount(Double.parseDouble(costoTotal));
		aTravel.setPassengerCount(Integer.parseInt(cantidadPasajeros));
		
		muberService.AddTravel(aTravel);
		
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}
	
	@RequestMapping(value = "/viajes/agregarPasajero", method = RequestMethod.PUT)
	public @ResponseBody String addPassengerInTravel(
			@RequestBody AgregarPasajero agregarPasajero) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		return "o";
	}
	
	@RequestMapping(value = "/viajes/calificar", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String rateToTravel(
			@RequestParam(value="viajeId", required = true) String conductorId,
			@RequestParam(value="pasajeroId", required = true) String pasajeroId,
			@RequestParam(value="puntaje", required = true) String puntaje,
			@RequestParam(value="comentario", required = true) String comentario) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}
	
	@RequestMapping(value = "/pasajeros/cargarCredito", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public String insertCredit(
			@RequestParam(value="pasajeroId", required = true) String pasajeroId,
			@RequestParam(value="monto", required = true) String monto) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}
			
	@RequestMapping(value = "/viajes/finalizar", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public String finishTravel(
			@RequestParam(value="viajeId", required = true) String viajeId) {
		// Corroborarar que se finalice una vez
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}		
	
	@RequestMapping(value = "/conductores/top10", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String topTenOfDrivers() {
		// Listar los 10 conductores mejor calificados que no tengan viajes abiertos registrad
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK"); 
		return new Gson().toJson(aMap);
	}	
}

