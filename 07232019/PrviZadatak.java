package prvipaket;

import java.util.Scanner;


public class PrviZadatak {

	public static void main(String[] args) {
		double a, b, c;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Unesite prvi broj: ");
		a = sc.nextDouble();
		System.out.println("Unesite drugi broj: ");
		b = sc.nextDouble();
		System.out.println("Unesite treci broj: ");
		c = sc.nextDouble();

		System.out.println((a+b+c) / 3);
	}

}
