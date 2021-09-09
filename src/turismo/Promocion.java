package turismo;

import java.util.List;

public abstract class Promocion implements Adquirible {
	
	List<Atraccion> atracciones;
	protected double costoPromo;
	
	public Promocion(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
		
	}
	
	//FIXME Ver que onda no salgan atracciones con diferente tipo

}
