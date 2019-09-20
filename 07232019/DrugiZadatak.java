package prvipaket;

import java.util.Scanner;

public class DrugiZadatak {

	public static void main(String[] args) {
		double r, c;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Unesite poluprecnik r: ");
		r = sc.nextDouble();
		c = (4 * r * r * r * Math.PI) / 3;
		
		System.out.println("Zapremina lopte je : " + c);
	}

}
