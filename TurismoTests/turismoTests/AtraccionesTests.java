package turismoTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import turismo.Atraccion;
import turismo.Usuario;

public class AtraccionesTests {

	@Test
	public void ocuparAtraccionTest() {
		Atraccion atraccion1 = new Atraccion("Moria", 50, 2, 6, "Aventura");
		atraccion1.ocuparAtraccion();
		assertEquals(5, atraccion1.getCupo());
	}
	
	@Test
	public void usuarioOcupaAtraccionTest() {
		Atraccion atraccion1 = new Atraccion("Moria", 50, 2, 6, "Aventura");
		Usuario turista = new Usuario("Eowyn", 110, 10, "Aventura");
		System.out.println(turista.getPresupuesto());
		System.out.println(turista.getTiempoDisponible());
		System.out.println(" ");
		atraccion1.ocuparAtraccion();
		assertEquals(5, atraccion1.getCupo());
		turista.setAtributos(atraccion1.getCosto(), atraccion1.getTiempoPromedio());
		System.out.println(turista.getPresupuesto());
		System.out.println(turista.getTiempoDisponible());
		
	}
	
}
