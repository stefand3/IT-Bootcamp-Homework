package dvasestsedam;

import java.util.Scanner;

public class PrviZadatak {

	public static void main(String[] args) {
		// // ZADATAK 1.1
		int n;
		int zbir = 0;
		Scanner sc = new Scanner(System.in);
		

		for (int i = 0; i < 5; i++) {
			System.out.print("Unesite " + (i+1) + ". broj: ");
			n = sc.nextInt();
			
			if(n >= 0) {
				zbir+=n;
			}
			else {
				break;
			}
		}
		System.out.println("Suma unetih pozitivnih brojeva je: " + zbir);
		
	}
}
