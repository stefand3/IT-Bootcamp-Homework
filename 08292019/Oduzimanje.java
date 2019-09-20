package cet29_08;

public class Oduzimanje extends BinarnaOperacija{

	public Oduzimanje(Izraz levi, Izraz desni) {
		super(levi, desni);
		// TODO Auto-generated constructor stub
	}

	private int vrL, vrD; // za String toString
	
	@Override
	public int izracunaj() {
		if(levi instanceof BinarnaOperacija) {
			vrL = levi.izracunaj();
		}
		else if(levi instanceof Broj) {
			vrL = ((Broj)levi).getVrednost();
		}
		else if (levi instanceof Promenljiva) {
			vrL = ((Promenljiva)levi).getVrednost();
		}
		
		if(desni instanceof BinarnaOperacija) {
			vrD = desni.izracunaj();
		}
		else if(desni instanceof Broj) {
			vrD =  ((Broj)desni).getVrednost();
		}
		else if(desni instanceof Promenljiva) {
			vrD = ((Promenljiva)desni).getVrednost();
		}
		
		return vrL - vrD;
	}

	public String toString() {
		return super.toString() + "Oduzimanje: " + (vrL - vrD);
	}
}
