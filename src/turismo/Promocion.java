package turismo;

import java.util.List;

public abstract class Promocion {
	
	List<Atraccion> atracciones;
	protected double costoPromo;
	
	public Promocion(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
		
	}
	
	//Hacer un metodo "ARMAR PROMO?" que extienda de atraccion?

}
