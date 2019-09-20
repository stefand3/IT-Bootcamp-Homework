package uto27_08;

public class Prodavnica {
	private String ime;
	private String lokacija;
	private Artikal[] artikli;

	private int count = 0;

	public Prodavnica(String ime, String lokacija) {
		this.ime = ime;
		this.lokacija = lokacija;
		artikli = new Artikal[10];
	}

	public Artikal[] pretrazi(String text) {
		int duzina = 0;

		for (int i = 0; i < artikli.length; i++) {
			if (artikli[i] != null) {
				if (artikli[i].ime().toLowerCase().contains(text.toLowerCase())) {
					duzina++;
				}
			}
		}

		Artikal[] temp = new Artikal[duzina];

		int j = 0;

		for (int i = 0; i < artikli.length; i++) {
			if (artikli[i] != null) {
				if(artikli[i].ime().toLowerCase().contains(text.toLowerCase())) {
					temp[j++] = artikli[i];
				}
				
			}
		}
//		for (Artikal a : temp) {
//			if(a != null) {
//				 {
//					duzina++;
//				}
//			}

//			if(a.ime() == text)
//				temp[j++] = a;
		return temp;
	}

	public void dodaj(Artikal a) {
		boolean flag = false;

		if (count < artikli.length)
			artikli[count++] = a;
		else {
			if (flag == false) { // samo jednom ce napraviti novi niz
				flag = true;
				Artikal[] noviNiz = new Artikal[artikli.length * 2];
				for (int i = 0; i < artikli.length; i++) {
					noviNiz[i] = artikli[i];
				}
				noviNiz[count++] = a;
				artikli = noviNiz;
				noviNiz = null;
			}
			return;
		}
	}

	public String getIme() {
		return ime;
	}

	public String getLokacija() {
		return lokacija;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ime + ": " + lokacija);

		for (int i = 0; i < artikli.length; i++) {
			if (artikli[i] != null) {
				sb.append("\n\t" + artikli[i]);
			}
		}

		return sb.toString();
	}

}
