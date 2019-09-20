package trinaestiosmi;

import java.util.Scanner;

public class Zadatak1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite N-ti broj: ");
		int n = sc.nextInt();
		
		System.out.println(n + ". tribonacijev broj je: " + tribonacci(n));
	}

	static int tribonacci(int n) {
		if(n == 0)
			return 0;
		else if (n == 1 || n == 2)
			return 1;
		else
			return tribonacci(n-3) + tribonacci(n-2) + tribonacci(n-1);
	}
}
