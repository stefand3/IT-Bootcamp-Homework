package dvapetsedam;

import java.util.Scanner;

public class TreciZadatak {
	// Znam da ne treba ovako al eto, radi :d
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);

		System.out.print("Unesite broj: ");
		n = sc.nextInt();
		
		if((n != 2 || n != 3 || n != 5 || n != 7 ) && n % 2 ==0 || n % 3 ==0 || n % 5 ==0) {
			System.out.print("Nije prost broj.");
		}
		else {
			System.out.print("Prost broj");
		}
	

	}

}
