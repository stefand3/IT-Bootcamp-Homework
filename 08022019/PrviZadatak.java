package drugiosmi;

import java.util.Scanner;

public class PrviZadatak {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		double tezina = tezina();
		double pol = pol();
		double bodyMass = bodyMass(tezina, pol);
		
		double suma = unos();
		
		bac(suma, bodyMass);
	}
	
	static double tezina() {
		Scanner sc = new Scanner(System.in);
		double tezina;
		double tezinaG;
		
		System.out.println("Dobrodosli u alko aproksimator 9000!");
		System.out.print("Unesite vasu tezinu: ");
		tezina = sc.nextDouble();
		
		tezinaG = tezina * 100000;
		return tezinaG;
	}

	static double pol() {
		Scanner sc = new Scanner(System.in);
		int pol; 
		double r = 0;
		
		System.out.print("Unesite vas pol(ako ste musko unesite 1, ako ste zensko unesite 0): ");
		pol = sc.nextInt();
		if(pol == 1) {
			r = 0.55;
		}
		else if (pol == 0) {
			r = 0.68;
		}
		return r;
	}
	
	static double bodyMass(double tezina, double pol) {
		double bodyMass = 0;
		bodyMass = tezina * pol;
		
		return bodyMass;
	}
	
	
	static double unos() {
		Scanner sc = new Scanner(System.in);
		int idPica;
		double mlPica;
		double suma = 0;
		double procenat = 0;
		
		do {
			System.out.print("Unesite ID pica koje ste pili ili -1 ako ste vec uneli sva pica koja ste popili: ");
			idPica = sc.nextInt();
			
			while((idPica < 1 || idPica > 4) && idPica != -1) {
				System.err.print("Greska, zeljeni id nije u bazi podataka. Pokusajte ponovo: ");
				idPica = sc.nextInt();
			}
			switch(idPica) {
			case 1: procenat = 50;break;
			case 2: procenat = 40;break;
			case 3: procenat = 4.7;break;
			case 4: procenat = 11;break;
			}
			if(idPica != -1) {
				System.out.print("Unesite koliko mililitara(ml) tog pica ste popili: ");
				mlPica = sc.nextDouble();
				suma += procenat * mlPica;
			}
			
		} while (idPica != -1);
		
		return suma;
	}
	
	static void bac(double suma, double bodyMass) {
		double bac = 0;
		bac = (suma / bodyMass) * 1000;
		//double bac2 = bac / 100;
		
		String string = null;
		String kazna = null;
		int kazneniPoeni = 0;
		int zabrana = 0;
		
		if(bac > 0 && bac <= 0.20) {
			string = "Dozvoljena alkoholisanost";
			kazna = "Bez kazne";
			kazneniPoeni = 0;
			zabrana = 0;
		}
		else if(bac >= 0.21 && bac <= 0.5) {
			string = "Umerena alkoholisanost";
			kazna = "10.000din.";
			kazneniPoeni = 0;
			zabrana = 0;
		}
		else if(bac >= 0.51 && bac <= 0.8) {
			string = "Srednja alkoholisanost";
			kazna = "10.000 - 20.000din.";
			kazneniPoeni = 6;
			zabrana = 3;
		}
		else if(bac >= 0.81 && bac <= 1.2) {
			string = "Visoka alkoholisanost";
			kazna = "20.000 - 40.000din.";
			kazneniPoeni = 8;
			zabrana = 4;
		}
		else if(bac >= 1.21 && bac <= 1.6) {
			string = "Teska alkoholisanost";
			kazna = "100.000 - 120.000din.";
			kazneniPoeni = 9;
			zabrana = 8;
		}
		else if(bac >= 1.61 && bac <= 2) {
			string = "Visoka alkoholisanost";
			kazna = "100.000 - 120.000din.";
			kazneniPoeni = 14;
			zabrana = 8;
		}
		else if(bac > 2) {
			string = "Potpuna alkoholisanost";
			kazna = "30 - 60 dana zatvora.";
			kazneniPoeni = 15;
			zabrana = 9;
		}
		
		System.out.println("----------------------------");
		System.out.printf("BAC: %.2f - " + string, bac); 
		//System.out.print(" - " + string);
		System.out.println("\n----------------------------");
		System.out.println("Kazna" + kazna);
		System.out.println("Kazneni poeni: " + kazneniPoeni);
		System.out.println("Zabrana: " + zabrana + " meseci");
		
	}
}
