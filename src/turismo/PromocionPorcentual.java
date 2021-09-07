package turismo;

import java.util.List;

public class PromocionPorcentual extends Promocion {

	public PromocionPorcentual(List<Atraccion> atracciones) {
		super(atracciones);
	}
	
	public double promoPorcentual(double porcentaje) {
		int sumaCostos = atracciones.get(0).getCosto() + atracciones.get(1).getCosto();
		return sumaCostos*(1-porcentaje/100);
	}
	
	public double ofrecerPromocion(Usuario turista, int porcentaje) {
		double tiempoPromo = atracciones.get(0).getTiempoPromedio() + atracciones.get(1).getTiempoPromedio();
		int sumaCostos = atracciones.get(0).getCosto() + atracciones.get(1).getCosto();
		
		if(turista.getTiempoDisponible() >= tiempoPromo && turista.getPresupuesto() >= sumaCostos) {
		return promoPorcentual(porcentaje);
		} else {
			throw new NoTieneTiempoODineroException("No tiene tiempo o el dinero es insuficiente");

	}
	
}


}
