package pet16_08;

public class Trougao {
	private Tacka tacka;
//	private Tacka[] tacke;

	private int a, b, c;
	private boolean nijePravilan;

	public Trougao(int a, int b, int c, Tacka tacka) {
		nijePravilan = false;
		//tacka = new Tacka(3, -1);
		
		if (((a + b) > c) && ((a + c) > b) && ((b + c) > a)) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.tacka = tacka;
		} 
		else {
			System.out.println("Trougao nije validan.");
			nijePravilan = true;
		}
			
	}

	public boolean jeJednokraki() {
		if (a == b || a == c || b == c)
			return true;
		else
			return false;
	}

	public double getPovrsina() {
		double s = (a + b + c) / 2;
		double povrsina = s * (s - a) * (s - b) * (s - c);

		return Math.sqrt(povrsina);
	}

	public int getObim() {
		int obim = a + b + c;
		return obim;
	}

	public void setA(int i) {
		if (((i + b) > c) && ((i + c) > b) && ((b + c) > i)) {
			a = i;
		} 
		else
			System.out.println("Unos nije validan");
	}
	public void setB(int i) {
		if (((a + i) > c) && ((a + c) > i) && ((i + c) > a)) {
			b = i;
		} 
		else
			System.out.println("Unos nije validan");
	}
	public void setC(int i) {
		if (((a + b) > i) && ((a + i) > b) && ((b + i) > a)) {
			c = i;
		} 
		else
			System.out.println("Unos nije validan");
	}
	
	public boolean jeIstaPocetnaTacka(Trougao t) {
		if(tacka.getX() == t.tacka.getX() &&
		   tacka.getY() == t.tacka.getY()) {
			return true;
		}
		else
			return false;
	}
	
	public String ispis() {
		String s = "";
		if(nijePravilan == false) {
			s+= "-Trougao sa pocetkom: " + tacka.ispisTacke();
			s+= "\n-Stranice trougla: " + a + ", " + b + ", " + c;
			s+= "\n-Povrsina i Obim: P= " + getPovrsina() + " O= " + getObim();
			return s;
		}
		else {
			return "Trougao nije kreiran pravilno";
		}
	}
	
	public void setTacka(int poz, Tacka t) {
		tacka = t;
	}
}
