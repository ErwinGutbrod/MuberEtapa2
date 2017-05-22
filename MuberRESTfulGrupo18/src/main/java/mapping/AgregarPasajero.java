package mapping;


public class AgregarPasajero {
	 int viajeId;
	 int pasajeroId;
	
	 
	public AgregarPasajero() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AgregarPasajero(int viajeId, int pasajeroId) {
		super();
		this.viajeId = viajeId;
		this.pasajeroId = pasajeroId;
	}
	public int getViajeId() {
		return viajeId;
	}
	public void setViajeId(int viajeId) {
		this.viajeId = viajeId;
	}
	public int getPasajeroId() {
		return pasajeroId;
	}
	public void setPasajeroId(int pasajeroId) {
		this.pasajeroId = pasajeroId;
	}
	
	
}

