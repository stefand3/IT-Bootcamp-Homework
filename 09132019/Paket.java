package pet13_09;

import java.util.ArrayList;

public class Paket extends Tovar{
	private ArrayList<Tovar> tovar;
	
	public Paket() {
		tovar = new ArrayList<Tovar>();
	}
	
	@Override
	public String vrsta() {
		StringBuilder sb = new StringBuilder();
		
		for(Tovar t : tovar) {
			sb.append(t.vrsta() + ", ");
		}
		sb.setLength(sb.length() -2);
		return sb.toString();
	}

	@Override
	public double tezina() {
		double tezina = 0;
		for(Tovar t : tovar) {
			tezina += t.tezina();
		}
		return tezina;
	}

	public boolean dodaj(Tovar t) {
		return tovar.add(t);
	}
	
	public String toString() {
		return "paket[" + vrsta() + "](" + tezina() + ")";
	}
}
