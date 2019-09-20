package prvipaket;

import java.util.Scanner;


public class TreciZadatak {

	public static void main(String[] args) {
		int unos, rezultat, a, b, c;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Unesite trocifreni broj: ");
		unos = sc.nextInt();
		a = unos / 100;
		b = (unos % 100) / 10;
		c = unos % 7;
		rezultat = a + b + c;
		
		System.out.println(rezultat);

	}

}
