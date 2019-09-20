package petiosmi;

import java.util.Arrays;
import java.util.Scanner;

public class PrviZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Unesite N: ");
		int n = sc.nextInt();

		int[] niz = new int[n];
		int r = 0;
		upis(niz);
		sortiranje(niz); // Arrays.sort(niz);
		

		for (int i = 0; i < niz.length - 1; i++) {
			if (niz[i] + 1 != niz[i + 1]) {
				r = niz[i] + 1;
			}
		}
		System.out.print("Nedostaje broj: " + r);
	}

	static void upis(int[] niz) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Unesite elemente: ");
		for (int i = 0; i < niz.length; i++) {
			niz[i] = sc.nextInt();
		}
	}

	static void sortiranje(int[] niz) {
		for (int i = 0; i < niz.length - 1; i++) {
			int temp;
			for (int j = i + 1; j < niz.length; j++) {
				if (niz[i] > niz[j]) {
					temp = niz[j];
					niz[j] = niz[i];
					niz[i] = temp;
				}
			}
		}

	}
}
