package osmiosmi;

import java.util.Scanner;

public class Zadatak2 {

	public static void main(String[] args) {
		int[][] niz = new int[3][3];
		int n = unos(niz);
		int suma = sumaReda(niz, n);
		System.out.println("Vreddnost je: " + suma);
	}

	static int sumaReda(int[][] niz, int n) {
		int suma = 0;

		for (int j = 0; j < 3; j++) {
			suma += niz[n][j];
		}
		return suma;
	}

	static int unos(int[][] niz) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			System.out.println("Unsite elemente niza: " + i);
			for (int j = 0; j < 3; j++) {
				niz[i][j] = sc.nextInt();
			}
		}

		System.out.println("Unesite vrednost N: ");
		int n = sc.nextInt();
		return n;
	}
}
