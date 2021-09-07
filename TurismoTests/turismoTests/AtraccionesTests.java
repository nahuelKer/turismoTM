package turismoTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import turismo.Atraccion;

public class AtraccionesTests {

	@Test
	public void ocuparAtraccionTest() {
		Atraccion atraccion1 = new Atraccion("Moria", 50, 2, 6, "Aventura");
		atraccion1.ocuparAtraccion();
		assertEquals(5, atraccion1.getCupo());
	}

}
