package cet12_09;

import java.util.LinkedList;

public class Predstava {
	private String naziv;
	private Pozoriste pozoriste;
	private LinkedList<Zaposleni> zaposleni;
	
	private int cnt = 0;
	
	public Predstava(String naziv, Pozoriste pozoriste, Reditelj reditelj) {
		this.naziv = naziv;
		this.pozoriste = pozoriste;
		zaposleni = new LinkedList<Zaposleni>();
		this.zaposleni.add(reditelj);
	}
	
	public boolean dodaj(Glumac g) {
		return zaposleni.add(g);
	}
	
	public boolean dodaj(Kostimograf k) {
		if(cnt < 2)
			return zaposleni.add(k);
		else
			return false;
	}

	public String getNaziv() {
		return naziv;
	}

	public Pozoriste getPozoriste() {
		return pozoriste;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(naziv + ":");
		for(Zaposleni z : zaposleni) {
			sb.append("\n\t" + z);
		}
		return sb.toString();
	}
	
	
}
