package dvasestsedam;

import java.util.Scanner;

public class DrugiZadatak {

	public static void main(String[] args) {
		// // ZADATAK 1.2
		int n;
		int zbir = 0;
		Scanner sc = new Scanner(System.in);

		

		for (int i = 0; i < 5; i++) {
			System.out.print("Unesite " + (i+1) + ". broj: ");
			n = sc.nextInt();
			
			if (n > 0) {
				zbir+=n;
			}
		}
		
		System.out.print("Suma unetih pozitivnih brojeva je: " + zbir);
	}
}
