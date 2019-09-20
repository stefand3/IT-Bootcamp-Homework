package pet13_09;

public abstract class Tovar {
	
	public abstract String vrsta();
	
	public abstract double tezina();
	
	public String toString() {
		return vrsta() + "(" + tezina() + ")";
	}
}
