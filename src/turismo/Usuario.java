package turismo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Usuario {
	
	private List<Adquirible> adquisiciones = new ArrayList<Adquirible>();
	private String nombre;
	private double presupuesto;
	private double tiempoDisponible;
	private String atraccionPreferida;

	public Usuario(String nombre, int presupuesto, double tiempoDisponible, String atraccionPreferida) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.atraccionPreferida = atraccionPreferida;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public String getAtraccionPreferida() {
		return atraccionPreferida;
	}
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", presupuesto=" + presupuesto + ", tiempoDisponible=" + tiempoDisponible
				+ ", atraccionPreferida=" + atraccionPreferida + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(atraccionPreferida, nombre, presupuesto, tiempoDisponible);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(atraccionPreferida, other.atraccionPreferida) && Objects.equals(nombre, other.nombre)
				&& presupuesto == other.presupuesto
				&& Double.doubleToLongBits(tiempoDisponible) == Double.doubleToLongBits(other.tiempoDisponible);
	}

	public static ArrayList<Usuario> getTuristas(String archivo) {
		ArrayList<Usuario> turistas = new ArrayList<Usuario>();
		Scanner sc = null;
		try { //
			sc = new Scanner(new File(archivo));
			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String datos[] = linea.split(", ");
				String nombre = datos[0];
				int presupuesto = Integer.parseInt(datos[1]);
				if(presupuesto < 0)
					throw new ValorNegativoException("Presupuesto negativo");
				Double tiempoDisponible = Double.parseDouble(datos[2]);
				if(tiempoDisponible < 0)
					throw new ValorNegativoException("Tiempo negativo?");
				String atraccionPreferida = datos[3];
				
				Usuario t1 = new Usuario(nombre, presupuesto, tiempoDisponible, atraccionPreferida);
				
				if (!turistas.contains(t1))
					turistas.add(t1);
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
			
			return turistas;
	}

	public void setAtributos(double valor1, double valor2) {
		this.presupuesto -= valor1;
		this.tiempoDisponible -= valor2;
	}

	public List<Adquirible> getAdquisiciones() {
		return adquisiciones;
	}
	

}
