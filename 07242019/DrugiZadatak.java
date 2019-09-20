package dvacetirisedam;

import java.util.Scanner;

public class DrugiZadatak {

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		
		if((n % 4 == 0) && (n % 100 != 0 || n % 400 == 0)) {
			System.out.println(n + ". jeste prestupna godina");
		}
		else {
			System.out.println(n + ". nije prestupna godina");
		}
		
	}
}
