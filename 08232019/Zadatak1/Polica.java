package pet23_08;

import java.util.Arrays;

public class Polica {
	public Knjiga[] knjige;
	private int brKnjiga = 0;
	
	public Polica() {
		knjige = new Knjiga[10];
	}
	
	public void dodajKnjigu(Knjiga k) {
		if(brKnjiga >= knjige.length)
			return;
		
		knjige[brKnjiga] = k;
		brKnjiga++;
	}
	
	public Knjiga dohvatiKnjigu(String naziv) {
		for (int i = 0; i < knjige.length; i++) {
			if(knjige[i].getNaziv().equals(naziv)) {
				return knjige[i];
			}
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(Knjiga knjiga : knjige) {
			if(knjiga != null) {
				sb.append(knjiga + "\n");
			}
//			sb.append(0 + ". " + knjiga + "\n");
		}
		
		return sb.toString();
	}
	
	
}
