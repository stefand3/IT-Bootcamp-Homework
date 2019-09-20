package dvasestsedam;

import java.util.Scanner;

public class SestiZadatak {

	public static void main(String[] args) {
		// ZADATAK 5
		int n, nDva;
		int a = 1, b = 1, c = 0, m = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("Unesite koji fibonacijev broj zelite: ");
		n = sc.nextInt();
		nDva = n;
		
		for (int i = 0; i < n; i++) {
			m = b;
			//System.out.print(b + " ");
			
			c = a + b;
			b = a;
			a = c;
			
		}
		
		System.out.println(nDva + ". Fibonacijev broj je: " + m);
	}
}


