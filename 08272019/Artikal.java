package uto27_08;

public abstract class Artikal {
	private double cena;
	private int kolicina;
	
	public static int id = 1;
	private int uid;
	
	public Artikal (double cena, int kolicina) {
		this.cena = cena;
		this.kolicina = kolicina;
		uid = id++;
	}
	
	abstract String ime();

	public boolean kupi() {
		if(kolicina > 0) {
			kolicina--;
			return true;
		}
		else 
			return false;
	}
	
	public double getCena() {
		return cena;
	}

	public int getKolicina() {
		return kolicina;
	}

	public int getUid() {
		return uid;
	}

	@Override
	public String toString() {
		return "#" + uid + ": " + ime() + " - " + cena + " [kol: " + kolicina + "]";
	}
	
	
}
