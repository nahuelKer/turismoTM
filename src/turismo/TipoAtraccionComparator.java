package turismo;

import java.util.Comparator;

public class TipoAtraccionComparator implements Comparator<Atraccion>{

	@Override
	public int compare(Atraccion a1, Atraccion a2) {
		return a1.getTipoAtraccion().compareTo(a2.getTipoAtraccion());
	}

}
