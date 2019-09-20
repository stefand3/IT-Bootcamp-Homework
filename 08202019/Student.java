package uto20_08;

public class Student {
	private String potpis; // ime i prezime jednim spejsom
	private String jmbg; //DDMMYYYY ostatak random cifre
	private Ocena[] ocene;
	
	public Student(String potpis, String jmbg, Ocena[] ocene) {
		this.potpis = potpis;
		this.jmbg = jmbg;
		this.ocene = ocene;	
	}
	
	public double getProsecnaOcena() {
		double rezultat = 0;
		int count = 0;
		
		for (int i = 0; i < ocene.length; i++) {
			if(ocene[i].getOcena() > 5) {
				rezultat += ocene[i].getOcena();
				count++;
			}
		}
		rezultat = rezultat / count;
		return rezultat;
	}
	
	
	public String getDatumRodjenja() {
		String s = jmbg.substring(0,7);
		return s.substring(0, 2) + "/" + s.substring(2, 4) + "/1" + s.substring(4, 7);
	}
	
	public static boolean starijiOd(Student s, int god) {
		String n = s.getDatumRodjenja().substring(6, 10);
		if(n.charAt(1) != '9') { // Ako dobijemo '001' proverava da li je 2000+ godiste
			n = n.substring(1, 4); 
			n = "2" + n; // umesto 1001god. bice 2001god.
		}
		
		int r = Integer.parseInt(n);
		
		if((2019 - r) >= god)
			return true;
		
		else 
			return false;
	}
	
	public static Student[] prosekVeciOd(Student[] nizStudenata, double ocena) {
		int count = 0;
		int k = 0;
		
		for (int i = 0; i < nizStudenata.length; i++) {
			if (nizStudenata[i].getProsecnaOcena() >= ocena)
				count++;
		}
		Student[] niz = new Student[count];
		
		for (int i = 0; i < nizStudenata.length; i++) {
			if (nizStudenata[i].getProsecnaOcena() > ocena) {
				niz[k] = nizStudenata[i];
				k++;
			}
		}
		
		return niz;
	}
	public String getIme() {
		String[] s = potpis.split(" ");
		return s[0];
	}
	
	public String getPrezime() {
		String[] s = potpis.split(" ");
		return s[1];
	}

	public String najboljaOcena() {
		double najvecaTrenutna = 0;
		double bodovi = 0;
		
		String imePr = "";
		
		for (int i = 0; i < ocene.length; i++) {
			if(ocene[i].getOcena() > najvecaTrenutna) {
				najvecaTrenutna = ocene[i].getOcena();
				imePr = ocene[i].getPr().getIme();
				
				bodovi = ocene[i].getBodovi(); // Ako imaju dve iste ocene da poredi bodove
			}
			else if (ocene[i].getOcena() == najvecaTrenutna) {
				if(ocene[i].getBodovi() > bodovi) {
					najvecaTrenutna = ocene[i].getOcena();
					imePr = ocene[i].getPr().getIme();
				}	
			}
		}
		
		return imePr;
	}

	
	public String getPotpis() {
		return potpis;
	}
	public void setPotpis(String potpis) {
		this.potpis = potpis;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public Ocena[] getOcene() {
		return ocene;
	}
	public void setOcene(Ocena[] ocene) {
		this.ocene = ocene;
	}
	
	
}
