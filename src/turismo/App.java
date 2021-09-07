package turismo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class App {
	
	public static void main(String[] args) throws IOException{
		//PRIMERO: Leo los archivos de entrada
		
		//"piloto.txt" contiene los turistas
		ArrayList<Usuario> turistas = Usuario.getTuristas("piloto.txt");
		
		//"atracciones.txt" contiene las atracciones
		ArrayList<Atraccion> atracciones = Atraccion.getAtracciones("atracciones.txt");
		
		//SEGUNDO: Inicializo un ArrayList "itinerario" donde se va a ir almacenando las elecciones del usuario
		List<Atraccion> itinerario = new ArrayList<Atraccion>();
		
		// TERCERO: Empiezo con las sugerencias
		for (int i = 0; i < turistas.size(); i++) {

			/*
			 * Guardo en una variable String la preferencia del usuario para pasarla por
			 * parametro al getAtraccionesPreferidas
			 */
			String preferenciasUsuario = turistas.get(i).getAtraccionPreferida();

			/*
			 * Filtro "atracciones" y obtengo una nueva lista SOLO con las atracciones
			 preferidas del usuario
			 */
			List<Atraccion> atraccionesPreferidas = Atraccion.getAtraccionesPreferidas(atracciones,
					preferenciasUsuario);
			
			/*Ordeno la lista atraccionesPreferidas por precio (de la mas cara a la mas barata)*/
			Atraccion.ordenarListaPorPrecio(atraccionesPreferidas);

			/*
			 * Inicializo una nueva promocion porcentual p1 pasandole por parametro las 2
			 * primeras atracciones mas caras del ArrayList "atraccionesPreferidas"
			 */

			Scanner entrada = new Scanner(new InputStreamReader(System.in));
			System.out.println("Esta interesado en la siguiente promocion?");
			System.out.println("Pack " + preferenciasUsuario + ": " + atraccionesPreferidas.get(0).getNombreAtraccion()
					+ " " + "y " + atraccionesPreferidas.get(1).getNombreAtraccion() + " "
					+ "con un 20% de descuento con la compra de ambas.");
			String opcion = entrada.nextLine();
			if (opcion.equals("si")) {

				PromocionPorcentual p1 = new PromocionPorcentual(atraccionesPreferidas.subList(1, 3));
				
				System.out.println("Enhorabuena! Usted ha adquirido el Pack" + " " + preferenciasUsuario + " " + "por $" + p1.ofrecerPromocion(turistas.get(i), 20));

				atraccionesPreferidas.get(0).ocuparAtraccion();

				atraccionesPreferidas.get(1).ocuparAtraccion();

				itinerario.add(atraccionesPreferidas.get(1));
				itinerario.add(atraccionesPreferidas.get(2));
				
				Iterator<Atraccion> itr1 = itinerario.iterator();
				while(itr1.hasNext()) {
					System.out.println(itr1.next());
				}
				
				//Ver como descontar del presupuesto
				
				

			} else if (opcion.equals("no")) {
				System.out.println("Esta interesado en la siguiente promocion?");
				System.out.println("Pack " + ": " + atraccionesPreferidas.get(0).getNombreAtraccion()
						+ " " + "y " + atraccionesPreferidas.get(1).getNombreAtraccion() + " "
						+ "con un 20% de descuento con la compra de ambas.");
				if(opcion.equals("si")) {
					System.out.println("imprimime");
				}
				
				
			} else {
				System.out.println("unshowprin");
			}

		}

	}

}

		


	

