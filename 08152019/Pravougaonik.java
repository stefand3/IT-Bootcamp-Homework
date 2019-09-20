package cet15_08;

public class Pravougaonik {
	private double a;
	private double b;
	private String ime;
	
	public Pravougaonik(double a, double b, String ime) {
		this.a = a;
		this.b = b;
		this.ime = ime;
	}

	public Pravougaonik(double b, String ime) {
		this.a = b;
		this.b = b;
		this.ime = ime;
	}
	
	public double getA() {
		return a;
	}
	
	public double getB() {
		return b;
	}
	
	public String getIme() {
		return ime;
	}
	
	public double getObim() {
		return a+b;
	}
	
	public double getPovrsina() {
		return a*b;
	}
	
	public String ispisPravougaonika() {
		String s = "";
		
		s+= "Pravougaonik: " + getIme();
		s+= "\nDuzina prve stranice je: " + getA();
		s+= "\nDuzina druge stranice je: " + getB();
		s+= "\nPovrsina pravougaonika je: " + getPovrsina();
		s+= "\nObim pravougaonika je: " + getObim();
		
		return s;
	}
}


