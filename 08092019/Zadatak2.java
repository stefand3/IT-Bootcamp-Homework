package devetiosmi;

import java.util.Scanner;

public class Zadatak2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] samoglasnici = { 'a', 'e', 'i', 'o', 'u' };

		System.out.print("Unesite String s: ");
		String unos = sc.nextLine();
		String split[] = unos.split(" ");

		String resenje = funkcija(split, samoglasnici);
		System.out.println("Najduzi podstring samoglasnika: " + resenje);

	}

	// Ako vec ime funkcije ne treba da bude "niz"..............
	static String funkcija(String[] split, char[] samoglasnici) {
		String rezultat = split[0];
		String novo = "";
		int r = 0;

		for (int i = 1; i < split.length; i++) {
			rezultat = rezultat.concat(split[i]);
		}
		rezultat = rezultat.toLowerCase();

		for (int i = 0; i < rezultat.length(); i++) {

			for (int j = 0; j < samoglasnici.length; j++) {
				if (rezultat.charAt(i) == samoglasnici[j]) {
					novo += novo.valueOf(rezultat.charAt(i));
				}
			}
		}
		return novo;
	}
}
