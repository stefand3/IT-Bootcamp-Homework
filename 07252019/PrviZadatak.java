package dvapetsedam;

import java.util.Scanner;

public class PrviZadatak {

	public static void main(String[] args) {
		int n, c;
		int novB = 0;
		int m;
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Unesite broj: ");
		n = sc.nextInt();
		m = n;
		
		while(n > 0) {
			c = n % 10;
			n /= 10;
			novB *= 10;
			novB += c;
		}
		
		if(m == novB) {
			System.out.print("Uneti broj jeste palindrom");
		}
		else {
			System.out.print("Uneti broj nije palindrom");
		}
	}

}
