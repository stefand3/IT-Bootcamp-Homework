package dvasestsedam;

import java.util.Scanner;

public class CetvrtiZadatak {

	public static void main(String[] args) {
		// // ZADATAK 3

		for (int i = 1; i < 101; i++) {

			if (i % 3 != 0 && i % 5 != 0) {
				System.out.print(i + " ");
			} 
			else if (i % 3 == 0 && i % 5 == 0) {
				System.out.print("FizzBuzz ");
			} 
			else if (i % 3 == 0 && i % 5 != 0) {
				System.out.print("Fizz ");
			} 
			else if (i % 3 != 0 && i % 5 == 0) {
				System.out.print("Buzz ");
			}

		}

	}
}

