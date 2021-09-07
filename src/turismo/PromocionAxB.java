package turismo;

import java.util.List;

public class PromocionAxB extends Promocion {

	public PromocionAxB(List<Atraccion> atracciones) {
		super(atracciones);
	}
	
	public int promoAxB() {
		int sumaCostos = atracciones.get(0).getCosto() + atracciones.get(1).getCosto();
		return (sumaCostos) + (atracciones.get(2).getCosto()*0);
	}
	
	public double ofrecerPromocion(Usuario turista) {
		double tiempoPromo = atracciones.get(0).getTiempoPromedio() + atracciones.get(1).getTiempoPromedio();
		int sumaCostos = atracciones.get(0).getCosto() + atracciones.get(1).getCosto();
		
		if(turista.getTiempoDisponible() >= tiempoPromo && turista.getPresupuesto() >= sumaCostos) {
		return this.costoPromo = promoAxB();
		} else {
			throw new NoTieneTiempoODineroException("No tiene tiempo o el dinero es insuficiente");

	}
	
}

}
