package pet23_08_dva;

import java.util.Date;

public class Asistent extends Nastavnik{
	private String smer;

	
	public Asistent(String ime, String prezime, Date godinaRodjenja, Date godinaZaposlenja, double plata,
			String omiljenPredmet, String[] listaPredmeta, String smer) {
		super(ime, prezime, godinaRodjenja, godinaZaposlenja, plata, omiljenPredmet, listaPredmeta);
		this.smer = smer;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getIme() + " " + super.getPrezime() + "\nGodina rodjenja: " + super.getGodinaRodjenja());
		sb.append("Godina zaposlenja" + super.getGodinaZaposlenja() + "\nPlata: " + super.getPlata());
		sb.append("Omiljen predmet" + super.getOmiljenPredmet() + "\nLista predmeta: ");
		
		for(String lp : super.getListaPredmeta()) {
			sb.append("\n\t"+lp);
		}
		sb.append("\nSmer: " + smer);
		return sb.toString();
	}
	
	
}
