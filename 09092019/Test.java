package pon09_09;

import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean jePrestupna = false;
		
		System.out.println("Unesite broj objekata: ");
		Osoba[] osobe = new Osoba[sc.nextInt()];
		sc.nextLine();
		
		int i = 0;
		while(i < osobe.length) {
			System.out.println("Unesite ime: ");
			String ime = sc.nextLine();
			System.out.println("Unesite prezime: ");
			String prezime = sc.nextLine();
			System.out.println("Unesite adresu: ");
			String adresa = sc.nextLine();
			System.out.println("1) Datum - - 2) JMBG");
			int dat = sc.nextInt();
			sc.nextLine();
			
			switch(dat) {
			case 1:
			{
				System.out.println("Unesite datum: dd.mm.yyyy.");
				String datum = sc.nextLine();
				// Provera da li je pravilan unos = 03.02.2000  ;mora da ima length 11
				if(datum.length() != 11) {
					System.err.println("Nepravilan unos");
					break;
				}
				String[] n = datum.split("\\.");
				if(n[0].length() == 1) {
					n[0] = "0" + n[0];
				}
				if(n[1].length() == 1) {
					n[1] = "0" + n[1];
				}
				// Proverava dane, mesece, godine
				if((Integer.parseInt(n[0]) < 1 || Integer.parseInt(n[0]) > 31) || 
						(Integer.parseInt(n[1]) < 1 || Integer.parseInt(n[0]) > 12) ||
						Integer.parseInt(n[2]) > 1999) {
					System.err.println("Nepravilan unos");
					break;
				}
				// Proverava da li je prestupna godina
				if(Integer.parseInt(n[2]) % 400 == 0 || (Integer.parseInt(n[2]) % 4 == 0 && Integer.parseInt(n[2]) % 100 != 0)) {
					jePrestupna = true;
				}
				if(Integer.parseInt(n[0]) == 29 && (Integer.parseInt(n[1]) == 02 || Integer.parseInt(n[1]) == 2) && jePrestupna == false) {
					System.err.println("Godina nije prestupna");
					break;
				}
				
				
				osobe[i++] = new OsobaD(ime, prezime, adresa, new Datum(Integer.parseInt(n[0]), Integer.parseInt(n[1]), Integer.parseInt(n[2])));
				break;
			}
			case 2:
			{
				System.out.println("Unesite JMBG: ");
				String JMBG = sc.nextLine();
				// Provera da li je pravilan unos = mora da ima length 13
				if(JMBG.length() != 13) {
					System.err.println("Nepravilan unos");
					break;
				}
				
				int dan = Integer.parseInt(JMBG.substring(0, 2));
				int mesec = Integer.parseInt(JMBG.substring(2, 4));
				int godina = Integer.parseInt("1" + JMBG.substring(4, 7));
				
				// Proverava dane, mesece, godine
				if((dan < 1 || dan > 31) || (mesec < 1 || mesec > 12) || godina > 1999) {
					System.err.println("Nepravilan unos");
					break;
				}
				// Proverava da li je prestupna godina
				if(godina % 400 == 0 || (godina % 4 == 0 && godina % 100 != 0)) {
					jePrestupna = true;
				}
				if(dan == 29 && (mesec == 02 || mesec == 2) && jePrestupna == false) {
					System.err.println("Godina nije prestupna");
					break;
				}
				
				
				JMBG = JMBG.substring(0,4) + "1" + JMBG.substring(4, 7);
				
				osobe[i++] = new OsobaJMBG(ime, prezime, adresa, JMBG);
				break;
			}
			default:
			}
		}
		
		Date today = (Date) Calendar.getInstance().getTime();
		
		/*главни програм затим исписује String-репрезентацију, нумеролошки број и String за
пребројавање троуглића оних особа чији нумеролошки број није 7 и којe немају нула у
данашњем String-у за троуглиће.*/
		
		
	}
}
