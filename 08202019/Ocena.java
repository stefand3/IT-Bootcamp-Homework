package uto20_08;

public class Ocena {
	private int bodovi;
	private Predmet pr;
	
	
	public Ocena(int bodovi, Predmet pr) {
		this.bodovi = bodovi;
		this.pr = pr;
	}


	public int getBodovi() {
		return bodovi;
	}


	public Predmet getPr() {
		return pr;
	}
	
	public double getOcena() {
		double ocena = 0;
		
		if(bodovi < 50) {
			ocena = 0;
		}
		
		else if (bodovi >= 50 && bodovi < 60) {
			ocena = 6;
		}
		else if(bodovi >= 60 && bodovi < 70) {
			ocena = 7;
		}
		else if(bodovi >= 70 && bodovi < 80) {
			ocena = 8;
		}
		else if(bodovi >= 80 && bodovi < 90) {
			ocena = 9;
		}
		else if(bodovi >= 90 && bodovi <= 100) {
			ocena = 10;
		}
		
		return ocena;
	}
	
	public String toString() {
		return "Predmet: " + pr.getIme() + ", Ocena: " + getOcena();
	}
}
