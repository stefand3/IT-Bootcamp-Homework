package petiosmi;

import java.util.Scanner;

public class DrugiZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Unesite N: ");
		int n = sc.nextInt();
		int[] niz = new int[n];

		unos(niz);
		int[] rezultat = niz(niz);

		System.out.println(rezultat[0] + ", " + rezultat[1]);
	}

	static void unos(int[] niz) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Unesite elemente: ");
		for (int i = 0; i < niz.length; i++) {
			niz[i] = sc.nextInt();
		}
	}

	static int[] niz(int[] niz) {
		int najmanji, najveci;
		najmanji = najveci = niz[0];

		for (int i = 1; i < niz.length; i++) {
			if (niz[i] > najveci) {
				najveci = niz[i];
			}
			if (niz[i] < najmanji) {
				najmanji = niz[i];
			}
		}
		int[] rezultat = new int[2];
		// int[] rezultat = { najmanji, najveci };
		rezultat[0] = najmanji;
		rezultat[1] = najveci;
		return rezultat;
	}
}
