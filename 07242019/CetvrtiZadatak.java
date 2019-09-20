package dvacetirisedam;

import java.util.Scanner;

public class CetvrtiZadatak {

	public static void main(String[] args) {
		int c, m;
		int n = 0;
		int r = 0;
		Scanner sc = new Scanner(System.in);

		System.out.print("Unesite broj: ");
		n = sc.nextInt();
		m = n;
		
		while (n > 0) {
			c = n % 10;
			n = n / 10;
			r += c * c * c;
		}
		
		if (m == r) {
			System.out.print("Broj " + m + " jeste Armstrongov");
		} 
		else {
			System.out.print("Broj " + m + " nije Armstrongov");
		}
		
	}
}
