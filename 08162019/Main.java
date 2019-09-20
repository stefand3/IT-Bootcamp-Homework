package pet16_08;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random r = new Random();
		
		// Niz tacaka, random vrednosti
		Tacka[] tacke = new Tacka[10];
		for (int i = 0; i < tacke.length; i++) {
			tacke[i] = new Tacka(r.nextInt(), r.nextInt());
		}
		
		// Kreiranje 3 trougla
		Trougao trougaoA = new Trougao(5, 5, 3, tacke[0]);
		Trougao trougaoB = new Trougao(5, 6, 8, tacke[1]);
		Trougao trougaoC = new Trougao(2, 4, 3, tacke[2]);
		
		// Provera jednokrakog
		if(trougaoA.jeJednokraki()){
			System.out.println("Jeste jednokraki");
		}
		else
			System.out.println("Nije jednokraki");
		
		// Ispis trougla
		System.out.println(trougaoB.ispis());
		
		// Da li je ista pocetna tacka - trougaoA i D
		Trougao trougaoD = new Trougao(6, 2, 4, tacke[0]);
		
		System.out.println(trougaoD.jeIstaPocetnaTacka(trougaoA));
		
//		//Set A
//		trougaoA.setA(1);
//		System.out.println(trougaoA.ispis());
	}

}
