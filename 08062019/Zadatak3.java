package sestiosmi;

import java.util.Scanner;

public class Zadatak3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Unesite N: ");
		int n = sc.nextInt();

		int[] niz = new int[n];
		unos(niz);
		double srvr = srednjaVrednost(niz, n);
		System.out.println("Srednja vrednost je: " + srvr);
		ispis(niz, srvr);
		double najblizi = najblizi(niz, srvr);
		System.out.println("\nNajblizi broj je: " + najblizi);

	}

	static void unos(int[] niz) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Unesite elemente: ");
		for (int i = 0; i < niz.length; i++) {
			niz[i] = sc.nextInt();
		}
	}

	static double srednjaVrednost(int[] niz, int n) {
		int suma = 0;
		double srvr;
		for (int i = 0; i < niz.length; i++) {
			suma += niz[i];
		}
		srvr = suma / n;

		return srvr;
	}

	static void ispis(int[] niz, double srvr) {
		System.out.print("Veci brojevi su: ");
		for (int i = 0; i < niz.length; i++) {
			if (niz[i] > srvr) {
				System.out.print(niz[i] + " ");
			}
		}
	}

	static double najblizi(int[] niz, double srvr) {
		double temp = 100;
		double razlika = 0;
		double brojIspis = 0;

		for (int i = 1; i < niz.length; i++) {
			if (niz[i] > srvr) {
				razlika = niz[i] - srvr;
			} 
			else if (niz[i] < srvr) {
				razlika = srvr - niz[i];
			}
			
			if(razlika < temp) {
				temp = razlika;
				brojIspis = niz[i];
			}

		}
		return brojIspis;
	}
}
