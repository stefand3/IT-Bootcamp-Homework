package prviosmi;

import java.util.Scanner;

public class Zadatakk {

	// Znam da je moglo(trebalo) sa vise funkcija da se uradi i da je ovako nabacano, 
	// ali sam dugo radio pa sam na kraju samo hteo da radi program xD
	static String ispis() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dobrodosli u Brasko++ pametnu kasu!");
		System.out.print("Koji je danas dan?(pon/uto/sre/cet/pet/sub/ned): ");
		//return sc.nextLine();
		String dan = sc.nextLine();
		//String dan = "ned";
		return dan;
		
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int kolicinaPizza = 0;
		int idMusterije = 0;

		/*System.out.println("Dobrodosli u Brasko++ pametnu kasu!");
		System.out.print("Koji je danas dan?(pon/uto/sre/cet/pet/sub/ned): ");
		String dan = sc.nextLine();*/
		String dan = ispis();
		do {
			for (int i = 1; kolicinaPizza != -1; i++) {
				System.out.print("Musterija id#" + i + ": ");
				kolicinaPizza = sc.nextInt();
				System.out.println("-- Racun za musteriju id#" + i + " ---");
				idPizze(kolicinaPizza, dan);
			}

		} while (kolicinaPizza != -1);

	}

	static void idPizze(int kolicinaPizza, String dan) {
		Scanner sc = new Scanner(System.in);
		int c2, c3, c5;
		c2 = c3 = c5 = 0;

		for (int i = 1; i <= kolicinaPizza; i++) {
			int idPizze = sc.nextInt();

			if (kolicinaPizza == 4 && i == 4) {
				System.out.println("AKCIJA 3+1, CETVRTA PIZZA JE BESPLATNA!");
				i++;
			}	
			else if(kolicinaPizza >= 7 && i % 7 == 0) {
				System.out.println("AKCIJA, SVAKA 7. PIZZA JE BESPLATNA!");
				i++;
			}
			else {
				switch (idPizze) {
				case 2:
					System.out.println("Pizza Cappricciosa 320");
					c2++;
					break;
				case 3:
					System.out.println("Pizza Pepperoni 290");
					c3++;
					break;
				case 5:
					System.out.println("Pizza Vesuvio 310");
					c5++;
					break;
				}
			}
		} // Kraj fora
		
		int racun = (c2 * 320) + (c3 * 290) + (c5 * 310);
		System.out.println("\t \t    ukupno: " + racun);
		int popust;

		if (dan == "uto") {
			popust = (c5 * 310) / 10;
			System.out.println("DNEVNA AKCIJA 10%  Vesuvio: -" + popust);
			racun -= popust;
			System.out.println("\t \t    ukupno: " + racun);
		} 
		else if (dan == "cet") {
			popust = (c2 * 320) / 10;
			System.out.println("DNEVNA AKCIJA 10%  Cappri.: -" + popust);
			racun -= popust;
			System.out.println("\t \t    ukupno: " + racun);
		} 
		else if (dan == "sub" || dan == "ned") {
			popust = racun / 15;
			System.out.println("DNEVNA AKCIJA 15% NA SVE:   -" + popust);
			racun -= popust;
			System.out.println("\t \t    ukupno: " + racun);
		}
		System.out.println("------------------------------------");

	}
}