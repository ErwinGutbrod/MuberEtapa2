package bd2.web;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.gson.Gson;

@ControllerAdvice
@RequestMapping("/services")
@ResponseBody
@EnableWebMvc
public class MuberRestController {

	protected Session getSession() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}

	@RequestMapping(value = "/services/pasajeros", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String getPassengers() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}
	
	@RequestMapping(value = "/services/viajes/abiertos", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String getTravelOpened() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}
	
	@RequestMapping(value = "/services/conductores", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String getDrivers() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}
	
	@RequestMapping(value = "/services/conductores/detalle", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String getDriverDetail(@RequestParam(value="conductorId", required = true) String conductorId) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}
	
	@RequestMapping(value = "/services/viajes/nuevo", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String getNewTravel(@RequestParam(value="conductorId", required = true) String conductorId,
			@RequestParam(value="origen", required = true) String origen,
			@RequestParam(value="destino", required = true) String destino,
			@RequestParam(value="conductorId", required = true) String cantidadPasajeros) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}
}


