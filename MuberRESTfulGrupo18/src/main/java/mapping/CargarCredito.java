package mapping;

public class CargarCredito {

	 int pasajeroId;
	 double monto;
	 
	 
	 
	public CargarCredito() {
		super();
	}
	
	public CargarCredito(int pasajeroId, double monto) {
		super();
		this.pasajeroId = pasajeroId;
		this.monto = monto;
	}
	public int getPasajeroId() {
		return pasajeroId;
	}
	public void setPasajeroId(int pasajeroId) {
		this.pasajeroId = pasajeroId;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	 
}
