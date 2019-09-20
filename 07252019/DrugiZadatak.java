package dvapetsedam;

import java.util.Scanner;

public class DrugiZadatak {

	public static void main(String[] args) {
		int n = 0, m = 0;
		int zbir = 0;
		Scanner sc = new Scanner(System.in);

		System.out.print("Unesite prvi broj: ");
		n = sc.nextInt();
		System.out.print("Unesite drugi broj: ");
		m = sc.nextInt();

		System.out.println("Parni brojevi izmedju " + n + " i " + m + " su:");
		for (int i = n; i < m; i++) {
			if (i % 2 == 0) {
				zbir = zbir + i;
				
				System.out.print(i + " ");
			}
			
		}

		System.out.print("\n" + "Zbir unetih brojeva je: " + zbir);

	}
}
