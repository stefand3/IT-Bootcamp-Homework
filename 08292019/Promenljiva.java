package cet29_08;

public class Promenljiva extends Izraz{
	private String ime;
	private int vrednost;
	
	
	public Promenljiva(String ime, int vrednost) {
		this.ime = ime;
		this.vrednost = vrednost;
	}


	@Override
	public int izracunaj() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int getVrednost() {
		return vrednost;
	}
	
	public String toString() {
		return "Ime: " + ime + ", Vrednost: " + vrednost;
	}
}
