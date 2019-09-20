package osmiosmi;

import java.util.Scanner;

public class Zadatak3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Unesite string: ");
		String s = sc.next();
		System.out.println("Unesite char: ");
		char c = sc.next().charAt(0); 
		
		int rezultat = brojKaraktera(s, c);
		System.out.println("Ponavalja se " + rezultat + " puta");
	}

	static int brojKaraktera(String string, char c) {
		int rezultat = 0;
		
		for (int i = 0; i < string.length(); i++) {
			if(string.charAt(i) == c) {
				rezultat += 1;
			}
		}
		
		return rezultat;
	}
}
