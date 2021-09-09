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
		
		
		// SEGUNDO: Empiezo con las sugerencias
		for (Usuario turista : turistas) {
			/* 
			 * Guardo en una variable String la preferencia del usuario para pasarla por
			 * parametro al getAtraccionesPreferidas
			 */
			String preferenciasUsuario = turista.getAtraccionPreferida();

			/*
			 * Filtro "atracciones" y obtengo una nueva lista SOLO con las atracciones
			 preferidas del usuario
			 */
			List<Atraccion> atraccionesPreferidas = Atraccion.getAtraccionesPreferidas(atracciones,
					preferenciasUsuario);
			
			/*Ordeno la lista atraccionesPreferidas por precio (de la mas cara a la mas barata)*/
			Atraccion.ordenarListaPorPrecio(atraccionesPreferidas);

			Scanner entrada = new Scanner(new InputStreamReader(System.in));
			System.out.println("Esta interesado en la siguiente promocion?");
			System.out.println("Pack " + preferenciasUsuario + ": " + atraccionesPreferidas.get(0).getNombreAtraccion()
					+ " " + "y " + atraccionesPreferidas.get(1).getNombreAtraccion() + " "
					+ "con un 20% de descuento con la compra de ambas.");
			String opcion = entrada.nextLine();
			if (opcion.equals("si")) {
				
				/*
				 * Inicializo una nueva promocion porcentual p1 pasandole por parametro las 2
				 * primeras atracciones mas caras del ArrayList "atraccionesPreferidas"
				 */

				PromocionPorcentual p1 = new PromocionPorcentual(atraccionesPreferidas.subList(1, 3));
				
				System.out.println("Enhorabuena! Usted ha adquirido el Pack" + " " + preferenciasUsuario + " " + "por $" + p1.ofrecerPromocion(turista, 20));
				
				//Modifico el atributo "cupo" de las atracciones a medida que son ocupadas
				atraccionesPreferidas.get(0).ocuparAtraccion();

				atraccionesPreferidas.get(1).ocuparAtraccion();

				
				//Agrego las atracciones al itinerario del usuario
				turista.getAdquisiciones().add(p1);
				
				double costoPaquete = atraccionesPreferidas.get(0).getCosto() + atraccionesPreferidas.get(1).getCosto();
				double tiempoPaquete = atraccionesPreferidas.get(0).getTiempoPromedio() + atraccionesPreferidas.get(1).getTiempoPromedio();
				
				//FIXME Ver que al descontar no exceda el presupuesto ni el tiempo (en teoria ya lo veo antes)
				
				turista.setAtributos(costoPaquete, tiempoPaquete);
				
				//FIXME metodo contains
				
				

			} else if (opcion.equals("no")) {
				System.out.println("Esta interesado en la siguiente promocion?");
				System.out.println("Pack " + ": " + atraccionesPreferidas.get(0).getNombreAtraccion()
						+ " " + "y " + atraccionesPreferidas.get(1).getNombreAtraccion() + " "
						+ "con un descuento de 30 monedas con la compra de ambas.");
				
				
				
				if(opcion.equals("si")) {
					System.out.println("imprimime");
				}
				
				
			} else {
				System.out.println("unshowprin");
			}

		}

	}

}

		


	

