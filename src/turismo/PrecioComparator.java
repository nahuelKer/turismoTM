package turismo;

import java.util.Comparator;

public class PrecioComparator implements Comparator<Atraccion>{

	@Override
	public int compare(Atraccion a1, Atraccion a2) {
		return Integer.compare(a1.getCosto(), a2.getCosto());
	}

}
