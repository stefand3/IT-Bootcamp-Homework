package trinaestiosmi;

import java.util.Scanner;

public class Zadatak3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Unesite duzinu niza A: ");
		int n = sc.nextInt();
		int[] a = new int[n];

		System.out.println("Unesite elemente niza A: ");
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}

		int[] rezultat = sortirajPoParnosti(a);
		
//		15 14 2 8 9 6 1
//		System.out.println(rezultat[0]);
//		System.out.println(rezultat[1]);
//		System.out.println(rezultat[2]);
//		System.out.println(rezultat[3]);
//		System.out.println(rezultat[4]);
//		System.out.println(rezultat[5]);
//		System.out.println(rezultat[6]);
	}

	static int[] sortirajPoParnosti(int[] a) {

		int brojac = 0;
		int[] rezultat = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				brojac++;
			}
		} // Broji parne brojeve

		int j = 0;
		int b = 0;
		for (int i = 0; i < brojac; i++) {
			for (j = b; j < rezultat.length; j++) {
				if (a[j] % 2 == 0) {
					rezultat[i] = a[j];
					b = j + 1;
					break;
				}
			}
		} // Ubacuje samo parne

		j = 0;
		b = 0;
		for (int i = brojac; i < rezultat.length; i++) {
			for (j = b; j < rezultat.length; j++) {
				if (a[j] % 2 != 0) {
					rezultat[i] = a[j];
					b = j + 1;
					break;
				}
			}
		} // Dodaje neparne

		return rezultat;
	}
}
