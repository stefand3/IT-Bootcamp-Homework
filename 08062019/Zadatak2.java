package sestiosmi;

import java.util.Random;
import java.util.Scanner;

public class Zadatak2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Unesite N: ");
		int n = sc.nextInt();
		System.out.print("Unesite gornju granicu: ");
		int granica = sc.nextInt();
		
		int[] niz = new int[n];
		//niz[n-1] = granica;
		
		random(niz, granica);
		//System.out.print(niz[0] + " " + niz[1] + " " +niz[2] + " " +niz[3] + " " +niz[4]);
		String rezultat = numberCheck(niz);
		System.out.println(rezultat);
	}

	static void random(int[] niz, int granica) {
		Random rd = new Random();
		for (int i = 0; i < niz.length; i++) {
			int broj = rd.nextInt(granica);
			niz[i] = broj;
		}
	}
	
	static String numberCheck(int[] niz) {
		String postoji = "Ne postoji";
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" Unesite broj: ");
		int broj = sc.nextInt();
		
		for (int i = 0; i < niz.length; i++) {
			if(niz[i] == broj) {
				postoji = "Postoji";
			}
			
		}
		
		return postoji;
	}
}
