package uto27_08;

import java.util.Date;

public class Album {
	private String naziv;
	private String izvodjac;
	private Date datum;
	private Numera[] lista = new Numera[5];

	private int count = 0;
	boolean flag = false;

	public Album(String naziv, String izvodjac, Date datum) {
		this.naziv = naziv;
		this.izvodjac = izvodjac;
		this.datum = datum;

		lista = new Numera[5];
	}

	public void dodaj(Numera n) {
		

		if (count < lista.length)
			lista[count++] = n;
		else {
			if (flag == false) { // samo jednom ce napraviti novi niz
				flag = true;
				Numera[] noviNiz = new Numera[lista.length * 2];
				for (int i = 0; i < lista.length; i++) {
					noviNiz[i] = lista[i];
				}
				noviNiz[count++] = n;
				lista = noviNiz;
				noviNiz = null;
			}
			return;
		}
	}

	public void dodaj(String name, String trajanje) {
		Numera m = new Numera(name, izvodjac, trajanje);
		
		if (count < lista.length)
			lista[count++] = m;
		else {
			if (flag == false) { // samo jednom ce napraviti novi niz
				flag = true;
				Numera[] noviNiz = new Numera[lista.length * 2];
				for (int i = 0; i < lista.length; i++) {
					noviNiz[i] = lista[i];
				}
				noviNiz[count++] = m;
				lista = noviNiz;
				noviNiz = null;
			}
			return;
		}
//		else // dodavanje 5 elemenata u nizPesama
//			nizPesama[count++] = m;
	}

	public String getTrajanje() { // upotrebi string bilder
		String[] s = new String[2];
		int minuti = 0;
		int sekunde = 0;

		for (int i = 0; i < count; i++) { // // // //
			s = lista[i].getTrajanje().split(":");
			minuti += Integer.parseInt(s[0]);
			sekunde += Integer.parseInt(s[1]);
		}

		if (sekunde >= 60) {
			minuti += sekunde / 60;
			sekunde = sekunde % 60;
		}
		return Integer.toString(minuti) + ":" + Integer.toString(sekunde);
	}

	public String getNaziv() {
		return naziv;
	}

	public String getIzvodjac() {
		return izvodjac;
	}

	public Numera getMuzizckaNumera(int poz) {
		if(poz >= 0 && poz < lista.length) {
			return lista[poz];
		}
		else return null;
	}

	public String toString() {
		int i = 0;
		StringBuilder sb = new StringBuilder();

		sb.append(izvodjac + " - " + naziv + "(" + datum + "):[\t\n");
		for (i = 0; i < count; i++) { // // // // //
			sb.append("\t" + lista[i] + "\n");
		}
		sb.append("]: " + getTrajanje() + "\n");

//		brnm = 0; // Ovde resetujem brojac koji sam stavio da je static da ne bi nastavio da broji
//						// za sledeci niz
		return sb.toString();
	}
}
