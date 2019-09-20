package pon09_09;

public class Datum {
	private int dan;
	private int mesec;
	private int godina;
	
	public Datum(int dan, int mesec, int godina) {
		this.dan = dan;
		this.mesec = mesec;
		this.godina = godina;
	}
	
	public Datum(Datum d) {
		this.dan = d.dan;
		this.mesec = d.mesec;
		this.godina = d.godina;
	}
	
	public String toString() {
		return dan + "." + mesec + "." + godina;
	}

	public int getDan() {
		return dan;
	}

	public int getMesec() {
		return mesec;
	}

	public int getGodina() {
		return godina;
	}
	
	
}
