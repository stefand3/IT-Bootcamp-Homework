package pet23_08_dva;

import java.util.Arrays;
import java.util.Date;

public class Nastavnik extends Zaposleni{
	private String omiljenPredmet;
	private String[] listaPredmeta;
	
	
	
	public Nastavnik(String ime, String prezime, Date godinaRodjenja, Date godinaZaposlenja, double plata,
			String omiljenPredmet, String[] listaPredmeta) {
		super(ime, prezime, godinaRodjenja, godinaZaposlenja, plata);
		this.omiljenPredmet = omiljenPredmet;
		this.listaPredmeta = listaPredmeta;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getIme() + " " + super.getPrezime() + "\nGodina rodjenja: " + super.getGodinaRodjenja());
		sb.append("Godina zaposlenja" + super.getGodinaZaposlenja() + "\nPlata: " + super.getPlata());
		sb.append("Omiljen predmet" + omiljenPredmet + "\nLista predmeta: ");
		
		for(String lp : listaPredmeta) {
			sb.append("\n\t"+lp);
		}
		
		return sb.toString();
	}

	public String getOmiljenPredmet() {
		return omiljenPredmet;
	}

	public String[] getListaPredmeta() {
		return listaPredmeta;
	}
	
	
}
