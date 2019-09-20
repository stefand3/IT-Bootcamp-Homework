package pon19_08;

import java.util.Date;
import java.lang.Object;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Album {
	private String naziv;
	private String izvodjac;
	private Date datum;
	private MuzickaNumera[] nizPesama;

	private int brnm = 0;

	public Album(String naziv, String izvodjac, Date datum) {
		this.naziv = naziv;
		this.izvodjac = izvodjac;
		this.datum = datum;

		nizPesama = new MuzickaNumera[5];
	}

	public void dodaj(MuzickaNumera mn) {
		int duzina = 0;
		if (brnm == nizPesama.length) {
			duzina = nizPesama.length;
			MuzickaNumera[] noviNiz = new MuzickaNumera[nizPesama.length * 2];
			for (int i = 0; i < nizPesama.length; i++) {
				noviNiz[i] = nizPesama[i];
			}
			noviNiz[brnm] = mn;
			brnm++;
		} else if (brnm > duzina && brnm < nizPesama.length) {
			nizPesama[brnm++] = mn;
		} else {
			nizPesama[brnm++] = mn;
		}

	}

	public void dodaj(String name, String trajanje) {
		MuzickaNumera m = new MuzickaNumera(name, izvodjac, trajanje);
		int duzina = 0;

		if (brnm == nizPesama.length) {
			duzina = nizPesama.length;
			MuzickaNumera[] noviNiz = new MuzickaNumera[nizPesama.length * 2];
			for (int i = 0; i < nizPesama.length; i++) {
				noviNiz[i] = nizPesama[i];
			}
			noviNiz[brnm] = m;
			brnm++;
		} else if (brnm > duzina && brnm < nizPesama.length) {
			nizPesama[brnm++] = m;
		} else {
			nizPesama[brnm++] = m;
		}
//		else // dodavanje 5 elemenata u nizPesama
//			nizPesama[brnm++] = m;
	}

	public String getTrajanje() { // upotrebi string bilder
		String[] s = new String[2];
		int minuti = 0;
		int sekunde = 0;

		for (int i = 0; i < brnm; i++) { // // // //
			s = nizPesama[i].getTrajanje().split(":");
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

	public MuzickaNumera getMuzizckaNumera(int poz) {
		return nizPesama[poz];
	}

	public MuzickaNumera getMuzizckaNumera(String ime) {
		MuzickaNumera m = null;

		for (int i = 0; i < nizPesama.length; i++) {
			if (nizPesama[i].getNaziv() == ime)
				m = nizPesama[i];
		}

		return m;
	}

	public String toString() {
		int i = 0;
		StringBuilder sb = new StringBuilder();

		sb.append(izvodjac + " - " + naziv + "(" + datum + "):[\t\n");
		for (i = 0; i < brnm; i++) { // // // // //
			sb.append("\t" + nizPesama[i] + "\n");
		}
		sb.append("]: " + getTrajanje() + "\n");

//		brnm = 0; // Ovde resetujem brojac koji sam stavio da je static da ne bi nastavio da broji
//						// za sledeci niz
		return sb.toString();
	}
	
//	public String toString() {
//		int i = 0;
//		String s = "";
//
//		System.out.println(izvodjac + " - " + naziv + "(" + datum + "):[\t");
//		for (i = 0; i < brnm; i++) { // // // // //
//			s = "\t" + nizPesama[i];
//			System.out.println(s);
//		}
//		System.out.println("]: " + getTrajanje());
//
////		brnm = 0; // Ovde resetujem brojac koji sam stavio da je static da ne bi nastavio da broji
////						// za sledeci niz
//		return "";
//	}
}
//	public void dodaj(MuzickaNumera mn) {
//		int duzina = nizPesama.length;
//
//		if (brnm == nizPesama.length) { // Ako je nizPesama pun, pravi novi niz
//			noviNiz = new MuzickaNumera[10];
//
//			for (int i = 0; i < nizPesama.length; i++) { // kopiranje elemenata u novi niz
//				noviNiz[i] = nizPesama[i];
//			}
//			noviNiz[nizPesama.length] = mn;
//			brnm++;
//		} 
//		else if (brnm > nizPesama.length && brnm < noviNiz.length) { // Kada se prekopira 5 elemenata da se nastavlja dodavanje
//			noviNiz[brnm++] = mn;
//		} 
//		else // dodavanje 5 elemenata u nizPesama
//			nizPesama[brnm++] = mn;
//	}

//	public void dodaj(String name, String trajanje) {
//		MuzickaNumera m = new MuzickaNumera(name, izvodjac, trajanje);
//		boolean flag = true;
//		
//		int duzina = nizPesama.length;
//		
//		if(brnm < 5){
//			nizPesama[brnm++] = m;
//		}
//		else if (brnm == duzina && flag == true) { // Ako je nizPesama pun, pravi novi niz
//			noviNiz = new MuzickaNumera[10];
//			flag = false;
//
//			for (int i = 0; i < duzina; i++) { // kopiranje elemenata u novi niz
//				noviNiz[i] = nizPesama[i];
//			}
//			noviNiz[duzina] = m;
//			brnm++;
//			return;
//		} 
//		else if (brnm > duzina && brnm < duzina) { // Kada se prekopira 5 elemenata da se nastavlja dodavanje
//			//brnm > duzina && brnm < noviNiz.length
//			noviNiz[brnm++] = m;
//		} 
////		else // dodavanje 5 elemenata u nizPesama
////			nizPesama[brnm++] = m;
//	}

//	public String getTrajanje() {
//		String[] s = new String[2];
//		int minuti = 0;
//		int sekunde = 0;
//
//		if (brnm <= nizPesama.length) {
//			for (int i = 0; i < brnm; i++) { // // // //
//				s = nizPesama[i].getTrajanje().split(":");
//				minuti += Integer.parseInt(s[0]);
//				sekunde += Integer.parseInt(s[1]);
//			}
//		} 
//		else {
//			for (int i = 0; i < brnm; i++) {
//				s = noviNiz[i].getTrajanje().split(":");
//				minuti += Integer.parseInt(s[0]);
//				sekunde += Integer.parseInt(s[1]);
//			}
//		}
//
//		if (sekunde >= 60) {
//			minuti += sekunde / 60;
//			sekunde = sekunde % 60;
//		}
//
//		return Integer.toString(minuti) + ":" + Integer.toString(sekunde);
//	}

//	public Date getDatum() {
//		return datum;
//	}

//	public MuzickaNumera getMuzizckaNumera(String ime) {
//		MuzickaNumera m = null;
//
//		if (brnm < nizPesama.length) {
//			for (int i = 0; i < nizPesama.length; i++) {
//				if (nizPesama[i].getNaziv() == ime)
//					m = nizPesama[i];
//			}
//		} else {
//			for (int i = 0; i < noviNiz.length; i++) {
//				if (noviNiz[i].getNaziv() == ime)
//					m = noviNiz[i];
//			}
//		}
//		return m;
//	}

//	public String toString() {
//		int i = 0;
//		String s = "";
//
//		if (brnm <= nizPesama.length) {
//			System.out.println(izvodjac + " - " + naziv + "(" + datum + "):[\t");
//			for (i = 0; i < brnm; i++) { // // // // //
//				s = "\t" + nizPesama[i];
//				System.out.println(s);
//			}
//			System.out.println("]: " + getTrajanje());
//		} else if (brnm > nizPesama.length) {
//			System.out.println(izvodjac + " - " + naziv + "(" + datum + "):[\t");
//
//			for (i = 0; i < brnm; i++) {
//				s = "\t" + noviNiz[i];
//				System.out.println(s);
//			}
//			System.out.println("]: " + getTrajanje());
//		}
//
//		Album.brnm = 0; // Ovde resetujem brojac koji sam stavio da je static da ne bi nastavio da broji
//						// za sledeci niz
//		return "";
//	}

