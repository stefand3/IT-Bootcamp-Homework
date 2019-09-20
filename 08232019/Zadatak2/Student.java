package pet23_08_dva;

import java.util.Date;

public class Student extends Covek{
	private int trenutnaGodinaStudija;
	private double trenutniProsek;
	
	 
	public Student(String ime, String prezime, Date godinaRodjenja, int trenutnaGodinaStudija, double trenutniProsek) {
		super(ime, prezime, godinaRodjenja);
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
		this.trenutniProsek = trenutniProsek;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getIme() + " " + super.getPrezime() + "\nGodina rodjenja: " + super.getGodinaRodjenja());
		sb.append("Trenutna godina studija: " + trenutnaGodinaStudija + "\nTrenutni prosek: " + trenutniProsek);
		return sb.toString();
	}

	public int getTrenutnaGodinaStudija() {
		return trenutnaGodinaStudija;
	}

	public double getTrenutniProsek() {
		return trenutniProsek;
	}
	
	
}
