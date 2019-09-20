package sestiosmi;

import java.util.Scanner;

public class Zadatak1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Unesite N: ");
		int n = sc.nextInt();
		
		int[] niz = new int[n];
		unos(niz);
		String rezultat = numberCheck(niz);
		System.out.println(rezultat);
	}
	
	static void unos(int[] niz) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Unesite elemente: ");
		for (int i = 0; i < niz.length; i++) {
			niz[i] = sc.nextInt();
		}
	}
	
	static String numberCheck(int[] niz) {
		String postoji = "Ne postoji";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Unesite broj: ");
		int broj = sc.nextInt();
		
		for (int i = 0; i < niz.length; i++) {
			if(niz[i] == broj) {
				postoji = "Postoji";
			}
			
		}
		
		return postoji;
	}
}
