package sestiosmi;

import java.util.Scanner;

public class Zadatak4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Unesite N: ");
		int n = sc.nextInt();

		int[] niz = new int[n];
		unos(niz);
		duplikati(niz);
	}

	static void unos(int[] niz) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Unesite elemente: ");
		for (int i = 0; i < niz.length; i++) {
			niz[i] = sc.nextInt();
		}
	}

	static void duplikati(int[] niz) {
		for (int i = 0; i < niz.length; i++) {
			for (int j = i+1; j < niz.length; j++) {
				if(niz[i] == niz[j]) {
					System.out.println("Postoje duplikati.");
				}
			}
		}
	}
}
