package turismo;

import java.util.List;

public class PromocionAbsoluta extends Promocion {

	public PromocionAbsoluta(List<Atraccion> atracciones) {
		super(atracciones);
	}
	
	public int promoAbsoluta(int descuento) {
		int sumaCostos = atracciones.get(0).getCosto() + atracciones.get(1).getCosto();
		return sumaCostos-descuento;
	}
	
	public double ofrecerPromocion(Usuario turista, int porcentaje) {
		double tiempoPromo = atracciones.get(0).getTiempoPromedio() + atracciones.get(1).getTiempoPromedio();
		int sumaCostos = atracciones.get(0).getCosto() + atracciones.get(1).getCosto();
		
		if(turista.getTiempoDisponible() >= tiempoPromo && turista.getPresupuesto() >= sumaCostos) {
		return this.costoPromo = promoAbsoluta(porcentaje);
		} else {
			throw new NoTieneTiempoODineroException("No tiene tiempo o el dinero es insuficiente");

	}
	
}


}
