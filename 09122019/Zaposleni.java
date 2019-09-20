package cet12_09;

public abstract class Zaposleni {
	private String ime;
	private Pozoriste pozoriste;
	
	public Zaposleni(String ime, Pozoriste pozoriste) {
		this.ime = ime;
		this.pozoriste = pozoriste;
	}
	
	public String getIme() {
		return ime;
	}
	public Pozoriste getPozoriste() {
		return pozoriste;
	}
	
	public abstract String imePosla();

	@Override
	public String toString() {
		return ime + "(" + imePosla() + ", " + pozoriste.getSkraceniNaziv() + ")";
	}
	
	
}
