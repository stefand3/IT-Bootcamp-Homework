package pet23_08_dva;

import java.util.Date;

public class Zaposleni extends Covek{
	private Date godinaZaposlenja;
	private double plata;
	
	
	public Zaposleni(String ime, String prezime, Date godinaRodjenja, Date godinaZaposlenja, double plata) {
		super(ime, prezime, godinaRodjenja);
		this.godinaZaposlenja = godinaZaposlenja;
		this.plata = plata;
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getIme() + " " + super.getPrezime() + "\nGodina rodjenja: " + super.getGodinaRodjenja());
		sb.append("Godina zaposlenja" + godinaZaposlenja + "\nPlata: " + plata);
		
		return sb.toString();
	}


	public Date getGodinaZaposlenja() {
		return godinaZaposlenja;
	}


	public double getPlata() {
		return plata;
	}
	
	
}
