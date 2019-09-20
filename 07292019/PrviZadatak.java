package dvadevetsedam;

import java.util.Scanner;

public class PrviZadatak {

	public static void main(String[] args) {
		// Imao sam vremena pa sam uradio da unos moze biti i negativan
		double cenaProizvoda;
		double kolicinaProizvoda;
		int novacKupca;
		double ukupnaCena = 0;
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i != -1; i++) {
			if (i == 1) { // Ako je prvi unos
				System.out.println("Unesite cenu 1. proizvoda: ");
				cenaProizvoda = sc.nextDouble();

				if (cenaProizvoda > 0) { // Ako je prvi unos dobar
					System.out.println("Unesite kolicinu 1. proizvoda: ");
					kolicinaProizvoda = sc.nextDouble();

					if (kolicinaProizvoda > 0) // Ako je kolicina pozitivna
						ukupnaCena += kolicinaProizvoda * cenaProizvoda;
					else { // Ako je kolicina negativna
						while (kolicinaProizvoda <= 0) {
							System.err.println("Kolicina mora biti pozitivan broj!");
							System.out.println("Unesite kolicinu 1. proizvoda: ");
							kolicinaProizvoda = sc.nextDouble();
						}
						ukupnaCena += kolicinaProizvoda * cenaProizvoda;
					}
				} else if (cenaProizvoda < 1) { // Ako je prvi unos los
					while (cenaProizvoda < 1) {
						System.err.println("Cena proizvoda ne moze biti manja od 1");
						System.out.println("Unesite cenu 1. proizvoda: ");
						cenaProizvoda = sc.nextDouble();
					}
					System.out.println("Unesite kolicinu 1. proizvoda: ");
					kolicinaProizvoda = sc.nextDouble();

					if (kolicinaProizvoda > 0) // Da li je kolicina pozitivna
						ukupnaCena += kolicinaProizvoda * cenaProizvoda;
					else { // Ako je kolicina negativna
						while (kolicinaProizvoda <= 0) {
							System.err.println("Kolicina mora biti pozitivan broj!");
							System.out.println("Unesite kolicinu 1. proizvoda: ");
							kolicinaProizvoda = sc.nextDouble();
						}
						ukupnaCena += kolicinaProizvoda * cenaProizvoda;
					}
				}
			} // Ako vise nije prvi unos
			else {
				System.out.println("Unesite cenu " + i + ". proizvoda ili (-1) ako nema vise proizvoda: ");
				cenaProizvoda = sc.nextDouble();

				if (cenaProizvoda > 0) { // Ako je prvi unos dobar
					System.out.println("Unesite kolicinu " + i + ". proizvoda: ");
					kolicinaProizvoda = sc.nextDouble();

					if (kolicinaProizvoda > 0) // Ako je kolicina pozitivna
						ukupnaCena += kolicinaProizvoda * cenaProizvoda;
					else { // Ako je kolicina negativna
						while (kolicinaProizvoda <= 0) {
							System.err.println("Kolicina mora biti pozitivan broj!");
							System.out.println("Unesite kolicinu " + i + ". proizvoda: ");
							kolicinaProizvoda = sc.nextDouble();
						}
						ukupnaCena += kolicinaProizvoda * cenaProizvoda;
					}
				} 
				else if(cenaProizvoda < 1 && cenaProizvoda != -1)
				{ 
					while (cenaProizvoda < 0 && cenaProizvoda != -1) {
						System.err.println("Cena proizvoda ne moze biti manja od 1");
						System.out.println("Unesite cenu " + i + ". proizvoda: ");
						cenaProizvoda = sc.nextDouble();
					}
					if (cenaProizvoda == -1){
						break;
						} 
					System.out.println("Unesite kolicinu " + i + ". proizvoda: ");
					kolicinaProizvoda = sc.nextDouble();

					if (kolicinaProizvoda > 0) 
						ukupnaCena += kolicinaProizvoda * cenaProizvoda;
					else { 
						while (kolicinaProizvoda <= 0) {
							System.err.println("Kolicina mora biti pozitivan broj!");
							System.out.println("Unesite kolicinu " + i + ". proizvoda: ");
							kolicinaProizvoda = sc.nextDouble();
						}
						ukupnaCena += kolicinaProizvoda * cenaProizvoda;
					}
				}
				else if(cenaProizvoda == -1) {
					break;
				}
			}

		}
		ukupnaCena = Math.round(ukupnaCena);
		
		System.out.println("Ukupna cena proizvoda je: " +  ukupnaCena);
		System.out.println("Koliko vam je novca dao kupac?");
		novacKupca = sc.nextInt();
		
		while(novacKupca < ukupnaCena) {
				System.err.println("Kupac nije dao dovoljno novca");
				System.out.println("Koliko vam je novca dao kupac?");
				novacKupca = sc.nextInt();
		}
		
		double kusur = novacKupca - ukupnaCena;
		System.out.println("Kusur je: " + kusur);
		
		int b20, b10, b5, b2, b1;
		b20 = b10 = b5 = b2 = b1 = 0;
		
		while (kusur > 0) {
		if(kusur >= 20) {
			kusur -= 20;
			b20++;
		}
		else if(kusur >= 10) {
			kusur -= 10;
			b10++;
		}
		else if(kusur >= 5) {
			kusur -= 5;
			b5++;
		}
		else if(kusur >= 2) {
			kusur -= 2;
			b2++;
		}
		else if(kusur >= 1) {
			kusur -= 1;
			b1++;
		}
		}
		
		System.out.println("20: "+ b20);
		System.out.println("10: "+ b10);
		System.out.println("5: "+ b5);
		System.out.println("2: "+ b2);
		System.out.println("1: "+ b1);
	}

}