package pon26_08;

public class Test {

	public static void main(String[] args) {
		Meni meni = new Meni(10);
		
		Hrana h1 = new Hrana("Hleb", 600, 7.5, 0.4, 49);
		Pice p1 = new Pice("Sok", 0.2, 18540);
		Hrana h2 = new Hrana("Sir", 200, 17, 1.2, 4);
		
		meni.dodaj(h1);
		meni.dodaj(p1);
		meni.dodaj(h2);
		
		System.out.println(meni);
	}

}
