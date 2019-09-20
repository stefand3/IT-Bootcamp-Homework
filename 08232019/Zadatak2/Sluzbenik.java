package pet23_08_dva;

import java.util.Date;

public class Sluzbenik  extends Zaposleni{
	private String odsek;

	public Sluzbenik(String ime, String prezime, Date godinaRodjenja, Date godinaZaposlenja, double plata,
			String odsek) {
		super(ime, prezime, godinaRodjenja, godinaZaposlenja, plata);
		this.odsek = odsek;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getIme() + " " + super.getPrezime() + "\nGodina rodjenja: " + super.getGodinaRodjenja());
		sb.append("Godina zaposlenja" + super.getGodinaZaposlenja() + "\nPlata: " + super.getPlata());
		sb.append("Odsek: " + odsek);
		return sb.toString();
	}
	
	
}
