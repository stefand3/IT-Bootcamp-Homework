package cet29_08;

public class Broj extends Izraz{
	private int vrednost;
	
	public Broj(int vrednost) {
		this.vrednost = vrednost;
	}
	
	public int getVrednost() {
		return vrednost;
	}

	@Override
	public int izracunaj() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString() {
		return "Vrednost broja: " + vrednost;
	}
}
