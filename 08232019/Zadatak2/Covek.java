package pet23_08_dva;

import java.util.Date;

public class Covek {
	private String ime;
	private String prezime;
	private Date godinaRodjenja;
	
	
	public Covek(String ime, String prezime, Date godinaRodjenja) {;
		this.ime = ime;
		this.prezime = prezime;
		this.godinaRodjenja = godinaRodjenja;
	}
	
	public Covek() {
		
	}
	
	@Override
	public String toString() {
		return ime + " " + prezime + "\nGodina rodjenja: " + godinaRodjenja;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public Date getGodinaRodjenja() {
		return godinaRodjenja;
	}
	
	
}
