package trinulasedam;

import java.util.Scanner;

public class PrviZadatak {

	public static void main(String[] args) {
		int a, b, c;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Unesite 1. broj: ");
		a = sc.nextInt();
		System.out.println("Unesite 2. broj: ");
		b = sc.nextInt();
		System.out.println("Unesite 3. broj: ");
		c = sc.nextInt();
		
		System.out.println("Najmanji broj je " + najmanji(a, b, c));

	}
	
	static int najmanji(int a, int b, int c) {
		int nBroj = 0;
		
		if(a < b && a < c)
			nBroj = a;
		else if(b < a && b < c)
			nBroj = b;
		else if(c < a && c < b)
			nBroj = c;
	
		return nBroj;
	}

}
