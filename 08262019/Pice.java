package pon26_08;

public class Pice extends Namirnica{
	private double kolicina; // količinom u litrima
	private double enVr; // energetskom	vrednošću jednog litra izraženoj u kJ (realan broj)
	
	
	public Pice(String ime, double kolicina, double enVr) {
		super(ime);
		this.kolicina = kolicina;
		this.enVr = enVr;
	}

	public double getKolicina() {
		return kolicina;
	}


	@Override
	public double energVr() {
		return kolicina*enVr;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(" (" + kolicina + "l, " + energVr() + "kJ)");
		
		return sb.toString();
	}
	
	
}
