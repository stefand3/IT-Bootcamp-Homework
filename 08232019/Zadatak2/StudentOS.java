package pet23_08_dva;

import java.util.Date;

public class StudentOS extends Student{
	private String smer;
	
	
	public StudentOS(String ime, String prezime, Date godinaRodjenja, int trenutnaGodinaStudija, double trenutniProsek,
			String smer) {
		super(ime, prezime, godinaRodjenja, trenutnaGodinaStudija, trenutniProsek);
		this.smer = smer;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getIme() + " " + super.getPrezime());
		sb.append("\nTrenutna godina studija: " + super.getTrenutnaGodinaStudija() + "\nTrenutni prosek: " + super.getTrenutniProsek());
		sb.append("\nSmer: " + smer);
		return sb.toString();
	}
	
	
}
