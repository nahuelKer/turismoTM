package turismo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Atraccion implements Adquirible{

	private String nombre;
	private int costo;
	private double tiempoPromedio;
	private int cupo;
	private String tipoAtraccion;

	public Atraccion(String nombre, int costo, double tiempoPromedio, int cupo, String tipoAtraccion) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempoPromedio = tiempoPromedio;
		this.cupo = cupo;
		this.tipoAtraccion = tipoAtraccion;
	}

	public int getCosto() {
		return costo;
	}

	public double getTiempoPromedio() {
		return tiempoPromedio;
	}

	public int getCupo() {
		return cupo;
	}

	public String getTipoAtraccion() {
		return tipoAtraccion;
	}
	
	public String getNombreAtraccion() {
		return nombre;
	}
	
	public void ocuparAtraccion() {
		this.cupo -= 1;
	}

	
	@Override
	public String toString() {
		return "Atraccion [nombre=" + nombre + ", costo=" + costo + ", tiempoPromedio=" + tiempoPromedio + ", cupo="
				+ cupo + ", tipoAtraccion=" + tipoAtraccion + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(costo, cupo, nombre, tiempoPromedio, tipoAtraccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return costo == other.costo && cupo == other.cupo && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(tiempoPromedio) == Double.doubleToLongBits(other.tiempoPromedio)
				&& Objects.equals(tipoAtraccion, other.tipoAtraccion);
	}
	
	public static ArrayList<Atraccion> getAtracciones(String archivo) {
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
		Scanner sc = null;
		try { //
			sc = new Scanner(new File(archivo));
			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String datos[] = linea.split(", ");
				String nombre = datos[0];
				int costo = Integer.parseInt(datos[1]);
				if(costo < 0)
					throw new ValorNegativoException("costo negativo?");
				Double tiempoPromedio = Double.parseDouble(datos[2]);
				if(tiempoPromedio < 0)
					throw new ValorNegativoException("Tiempo negativo?");
				int cupo = Integer.parseInt(datos[3]);
				if(cupo < 0)
					throw new ValorNegativoException("Cupo negativo?");
				String tipoAtraccion = datos[4];
				
				Atraccion a1 = new Atraccion (nombre, costo, tiempoPromedio, cupo, tipoAtraccion);
				
				if (!atracciones.contains(a1))
					atracciones.add(a1);
			}
			
			}
			
			catch (NumberFormatException nfe) {
				System.err.println("Uno de los datos leidos no es un numero");
			}
			
			catch (ValorNegativoException vne) {
				System.err.println(vne.getMessage());
			}
			
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
			sc.close();
			
			return atracciones;
	}
	
	public static void ordenarListaPorPrecio(List<Atraccion> atraccion) {
		Collections.sort(atraccion, new PrecioComparator().reversed());
	}
	
	public static void ordenarListaPorTipo(List<Atraccion> atraccion) {
		Collections.sort(atraccion, new TipoAtraccionComparator());
	}
	
	public static List<Atraccion> getAtraccionesPreferidas (List<Atraccion> atracciones, String atraccionPreferida){
		
		List<Atraccion> atraccionesPreferidas = new ArrayList<Atraccion>();
		for(Atraccion ca : atracciones)
			if(ca.getTipoAtraccion().equals(atraccionPreferida))
				atraccionesPreferidas.add(ca);
		
		return atraccionesPreferidas;
	}

}
