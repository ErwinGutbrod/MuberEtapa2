package mapping;

public class CargarCredito {

	 String pasajeroId;
	 String monto;
	 
	 
	 
	public CargarCredito() {
		super();
	}
	
	public CargarCredito(String pasajeroId, String monto) {
		super();
		this.pasajeroId = pasajeroId;
		this.monto = monto;
	}
	public String getPasajeroId() {
		return pasajeroId;
	}
	public void setPasajeroId(String pasajeroId) {
		this.pasajeroId = pasajeroId;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	 
}
