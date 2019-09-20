package trinulasedam;

import java.util.Scanner;

public class DrugiZadatak {

	public static void main(String[] args) {
		double n, k;
		Scanner sc = new Scanner(System.in);

		System.out.println("Unesite broj N:  ");
		n = sc.nextDouble();
		System.out.println("Unesite broj K: ");
		k = sc.nextDouble();

		System.out.println(funkcija(n, k));
	}

	// N=5; K=3; S= 3.564285714285714; 
	static double funkcija(Double n, Double k) {
		double s = 0;

		for (double i = 1; i < n + 1; i++) {
			s += i / (k + (i - 1)); // 2.814285714285714
		} 
		s += (n+1) / (n+k); // 0.75
		 
		return s;
	}
	
}