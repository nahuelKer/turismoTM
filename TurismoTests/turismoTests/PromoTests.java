package turismoTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import turismo.Atraccion;
import turismo.Promocion;
import turismo.PromocionAbsoluta;
import turismo.PromocionAxB;
import turismo.PromocionPorcentual;
import turismo.Usuario;

public class PromoTests {
	
	Usuario turista;
	Atraccion atraccion1;
	Atraccion atraccion2;
	Promocion promocion;
	ArrayList<Atraccion> atraccionesPromocion;
	
	/*@Before
	public void setup() {
		atraccion1 = new Atraccion("Moria", 2, 2, 6, "Aventura");
		atraccion2 = new Atraccion("Minas Tirith", 5, 2.5, 25, "Paisaje");
		atraccionesPromocion = new ArrayList<Atraccion>();
		promocion = new PromocionPorcentual(50, atraccionesPromocion);
		turista = new Usuario("Eowyn", 8, 10, "Aventura");
	}*/
	
	@Test
	public void puedePagartest() {
		//Creo el turista
		Usuario turista = new Usuario("Eowyn", 110, 10, "Aventura");
		//Creo las atracciones
		Atraccion atraccion1 = new Atraccion("Moria", 50, 2, 6, "Aventura");
		Atraccion atraccion2 = new Atraccion("Minas Tirith", 50, 2.5, 25, "Paisaje");
		//Creo el arrayList donde van las atracciones
		ArrayList<Atraccion> atraccionesPromocion = new ArrayList<Atraccion>();
		
		//Agrego las atracciones al arrayList
		atraccionesPromocion.add(atraccion1);
		atraccionesPromocion.add(atraccion2);
		
		
		//Creo la promo porcentual
		PromocionPorcentual promocion = new PromocionPorcentual(atraccionesPromocion);
		
		assertEquals(90, promocion.promoPorcentual(10), 0);
		
		System.out.println(promocion.ofrecerPromocion(turista, 10));
		
		PromocionAbsoluta promo2 = new PromocionAbsoluta(atraccionesPromocion);
		
		assertEquals(80, promo2.promoAbsoluta(20));
		
		System.out.println(promo2.ofrecerPromocion(turista, 20));
		
		
	}
	
	@Test
	public void promoAxBtest() {
		//Creo el turista
		Usuario turista = new Usuario("Eowyn", 110, 10, "Aventura");
		//Creo las atracciones
		Atraccion atraccion1 = new Atraccion("Moria", 50, 2, 6, "Aventura");
		Atraccion atraccion2 = new Atraccion("Minas Tirith", 50, 2.5, 25, "Paisaje");
		Atraccion atraccion3 = new Atraccion("La Comarca", 3, 6.5, 150, "Degustacion");
		//Creo el arrayList donde van las atracciones
		ArrayList<Atraccion> atraccionesPromocion = new ArrayList<Atraccion>();
		
		//Agrego las atracciones al arrayList
		atraccionesPromocion.add(atraccion1);
		atraccionesPromocion.add(atraccion2);
		atraccionesPromocion.add(atraccion3);
		
		
		PromocionAxB promo3 = new PromocionAxB(atraccionesPromocion);
		
		assertEquals(100, promo3.promoAxB());
		System.out.println(promo3.ofrecerPromocion(turista));

	}
	
	@Test
	public void promoPorcentualTest() {
		Usuario turista = new Usuario("Eowyn", 110, 10, "Aventura");
		Atraccion atraccion1 = new Atraccion("Moria", 50, 2, 6, "Aventura");
		Atraccion atraccion2 = new Atraccion("Minas Tirith", 50, 2.5, 25, "Paisaje");
		
		ArrayList<Atraccion> atraccionesPromocion = new ArrayList<Atraccion>();
		
		atraccionesPromocion.add(atraccion1);
		atraccionesPromocion.add(atraccion2);
		
		PromocionPorcentual promo = new PromocionPorcentual(atraccionesPromocion);
		
		System.out.println(promo.ofrecerPromocion(turista, 20));
	
	}
}