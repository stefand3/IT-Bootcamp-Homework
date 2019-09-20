package dvasestsedam;

import java.util.Scanner;

public class TreciZadatak {

	public static void main(String[] args) {
		// // ZADATAK 2.0
		
		int n, m, x1;
		int nBroj = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Unesite broj N: ");
		n = sc.nextInt();
		m = n;
		
		while(n > 0) {
			x1 = n % 10;
			
			if(x1 > nBroj) {
				nBroj = x1;
			}
			else if (nBroj == 9) {
				System.out.print("Najveca cifra broja " + m + " je: 9");
				break;
			}
			n /= 10;
		}
		
		if(nBroj <9) {
			System.out.print("Najveca cifra broja " + m + " je: " + nBroj);
		}

	}
}
