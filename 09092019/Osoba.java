package pon09_09;

public abstract class Osoba {
	private String ime;
	private String prezime;
	private String adresa;
	static int id = 1;
	private int uid;
	
	public Osoba(String ime, String prezime, String adresa) {
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
		uid = id++;
	}
	
	public Osoba(Osoba o) {
		this.ime = o.ime;
		this.prezime = o.prezime;
		this.adresa = o.adresa;
	}
	
	public abstract int numeroloskiBroj();
	
	public abstract String metabolizam(final Datum d);
}
