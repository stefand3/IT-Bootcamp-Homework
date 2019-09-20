package cet29_08;

public abstract class BinarnaOperacija extends Izraz{
	protected Izraz levi, desni;
	
	public BinarnaOperacija(Izraz levi, Izraz desni) {
		this.levi = levi;
		this.desni = desni;
	}

	public Izraz getLevi() {
		return levi;
	}

	public Izraz getDesni() {
		return desni;
	}
	
	public abstract int izracunaj();
	
	public String toString() {
		return "Levi: " + ((Broj)levi).getVrednost() + "\n Desni: " + ((Broj)desni).getVrednost();
	}
}
