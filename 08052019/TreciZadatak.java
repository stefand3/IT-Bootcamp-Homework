package petiosmi;

import java.util.Scanner;

public class TreciZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Unesite N: ");
		int n = sc.nextInt();

		int[] niz = new int[n];
		upis(niz);
		double rezultat;
		rezultat = sredina(niz, n);
		System.out.println(rezultat);
		sortiranje(niz); // Arrays.sort(niz);
		rezultat = medijana(niz, n);
		System.out.println(rezultat);

	}

	static void upis(int[] niz) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Unesite elemente: ");
		for (int i = 0; i < niz.length; i++) {
			niz[i] = sc.nextInt();
		}
	}

	static double sredina(int[] niz, int n) {
		double rez = 0;
		for (int i = 0; i < niz.length; i++) {
			rez += niz[i];
		}
		rez = rez / n;
		return rez;
	}

	static void sortiranje(int[] niz) {
		int temp;
		for (int i = 0; i < niz.length - 1; i++) {
			for (int j = i + 1; j < niz.length; j++) {
				if (niz[j] < niz[i]) {
					temp = niz[j];
					niz[j] = niz[i];
					niz[i] = temp;
				}
			}
		}
	}

	static double medijana(int[] niz, int n) {
		double rez = 0;
		int p, d;
		for (int i = 0; i < niz.length; i++) {
			if (n % 2 == 0) {
				p = niz[(n/2)-1];
				d = niz[n/2];
				rez = (niz[p]+niz[d]) / 2;
			} 
			else {
				rez = niz[(n-1)/2];
			}
		}
		return rez;
	}
}
