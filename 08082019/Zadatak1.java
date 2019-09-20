package osmiosmi;

import java.util.Scanner;

public class Zadatak1 {
	// Ako sam dobro razumeo zadatak..
	public static void main(String[] args) {
		int[][] niz = new int[5][3];
		unos(niz);
		int[] minMax = minMax(niz);
		System.out.println("Najmanji broj: " + minMax[0] + "\nNajveci broj: " + minMax[1]);

	}

	static int[] minMax(int[][] niz) {
		int najmanji = 0;
		int najveci = 0;
		int[] rezultat = new int[2];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				if (niz[i][j] < najmanji) {
					najmanji = niz[i][j];
				} 
				else if (niz[i][j] > najveci) {
					najveci = niz[i][j];
				}
			}
		}
		rezultat[0] = najmanji;
		rezultat[1] = najveci;
		return rezultat;
	}

	static void unos(int[][] niz) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.println("Unsite elemente niza: " + i);
			for (int j = 0; j < 3; j++) {
				niz[i][j] = sc.nextInt();
			}
		}
	}
}
