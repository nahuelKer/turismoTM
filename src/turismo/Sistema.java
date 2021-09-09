package turismo;

import java.util.ArrayList;
import java.util.Iterator;

public class Sistema {
	
	public static void main(String[] args) {
		
		Usuario t1 = new Usuario("Eowyn", 10, 8, "Aventura");
		
		String atraPref = t1.getAtraccionPreferida();
		
		//Atraccion a1 = new Atraccion("Moria", 2, 4, 6, "Aventura");
		//ArrayList<Usuario> turistas = Usuario.getTuristas("turistas.txt");
		
		ArrayList<Atraccion> atracciones = Atraccion.getAtracciones("atracciones.txt");
		
		Atraccion.ordenarListaPorTipo(atracciones);
		
		//ArrayList<Atraccion> atraccionesPreferidas = (ArrayList<Atraccion>) Atraccion.getAtraccionesPreferidas(atracciones, atraPref);
		
		Iterator<Atraccion> itr1 = atracciones.iterator();
		while(itr1.hasNext()) {
			System.out.println(itr1.next());
		}
		
		
		/*Atraccion.ordenarListaPorPrecio(atraccionesPreferidas);
		
		
		Iterator<Atraccion> itr2 = atraccionesPreferidas.iterator();
		while(itr2.hasNext()) {
			System.out.println(itr2.next());
		}*/
		
		
		/*Atraccion.ordenarListaPorPrecio(atracciones);
		System.out.println(" ");
		//Atraccion.ordenarListaPorTipo(atracciones);
		
		Iterator<Usuario> itr = turistas.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}*/
		
		/*Iterator<Atraccion> itr1 = atracciones.iterator();
		while(itr1.hasNext()) {
			System.out.println(itr1.next());
		}*/
		
		/*
		for(Usuario u1 : turistas) {
			System.out.println(u1);
		}
		
		for(Atraccion a1 : atracciones) {
			System.out.println(a1);
		}*/
		
		
	}

}
