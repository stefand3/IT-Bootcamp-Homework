package auto;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * Ako uplata vec postoji da se samo doda na uplatu
		 * Negde je rs.getInt() a negde je deklarisano
		 * Srpski/Engleski mesan
		 * PreparedStatement ps ps2 ps3
		 */
		Scanner sc = new Scanner(System.in);
		
		Prodavnica radnja = new Prodavnica("jdbc:sqlite:C:\\Users\\david\\OneDrive\\Desktop\\Prodavnica.db");
		//Prodavnica radnja = new Prodavnica("jdbc:sqlite:C:\\Users\\david\\OneDrive\\Desktop\\FudbalskiSavez.db");
		radnja.connect();
		
		System.out.println("Dobrodosli u prodavnicu automobila!");
		System.out.println("Izaberite jednu od sledecih opcija: ");
		System.out.println("1. Ulogujte se");
		System.out.println("2. Kreiraj nalog");
		int odabir = sc.nextInt();
		sc.nextLine();
		String username;
		String password;
		
		switch(odabir) {
		case 1:{
			System.out.println("----------------------");
			System.out.println("Unesite korisnicko ime: ");
			username = sc.nextLine();
			System.out.println("Unesite sifru: ");
			password = sc.nextLine();
			radnja.login(username, password);
			
			if(radnja.uspesnoLog()) {
				System.out.println("----------------------");
				System.out.println("Izaberite jednu od sledecih opcija: ");
				System.out.println("1. Pogledajte automobile koje mozete kupiti");
				System.out.println("2. Uplatite novac za neki od vec kupljenih automobila");
				int odabir2 = sc.nextInt();
				sc.nextLine();
				switch(odabir2) {
				case 1: {
					radnja.prikaziAutomobile();
					System.out.println("Napisite Id Automobila koji zelite da kupite");
					int idA = sc.nextInt();
					radnja.kupiAutomobil(username, idA);
				}
				case 2:{
					radnja.prikaziKupljeneAutomobile();
					System.out.println("Za koji automobil zelite da uplatite iznos? (Id Automobila)");
					int idA = sc.nextInt();
					System.out.println("Unesite iznos uplate: ");
					int iznos = sc.nextInt();
					radnja.uplatiNovac(idA, iznos);
				}
				default:
				}
			}
			
			break;
		}
		case 2:{
			System.out.println("----------------------");
			System.out.println("Unesite korisnicko ime: ");
			username = sc.nextLine();
			System.out.println("Unesite sifru: ");
			password = sc.nextLine();
			
			radnja.register(username, password);
			break;
		}
		default : System.err.println("Pogresan unos!");break;
		}
		
		radnja.disconnect();
	}

}
