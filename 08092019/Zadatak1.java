package devetiosmi;

import java.util.Scanner;

public class Zadatak1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Unesite String s: ");
		String unos = sc.nextLine();
		String split[] = unos.split(" ");

		String resenje = palindrom(split);
		System.out.println(resenje);

	}

	static String palindrom(String[] s) {
		String string = "jeste";
		String rezultat = s[0];

		for (int i = 1; i < s.length; i++) {
			rezultat = rezultat.concat(s[i]);
		}
		rezultat = rezultat.toLowerCase();
		int n = rezultat.length();

		for (int i = 0, j = n - 1; i < n; i++, j--) {
			if (rezultat.charAt(i) != rezultat.charAt(j)) {
				string = "nije";
			}
		}

		return string;

	}
}
