package trinaestiosmi;

import java.util.Scanner;

public class Zadatak2 {

	public static void main(String[] args) {
		int[] a = unosNizaA();
		int[] b = unosNizaB();
		
		boolean rezultat = podskup(a, b);
		if(rezultat)
			System.out.println("Niz A jeste podskup niza B");
		else
			System.out.println("Niz A nije podskup niza B");
	}

	static boolean podskup(int[] a, int[] b) {
		boolean flag = false;

		for (int i = 0; i < a.length; i++) {
			flag = false;
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

	static int[] unosNizaA() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Unesite duzinu niza A: ");
		int n = sc.nextInt();
		int[] a = new int[n];

		System.out.println("Unesite elemente niza A: ");
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}

		return a;
	}

	static int[] unosNizaB() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Unesite duzinu niza B: ");
		int m = sc.nextInt();
		int b[] = new int[m];

		System.out.println("Unesite elemente niza B: ");
		for (int i = 0; i < b.length; i++) {
			b[i] = sc.nextInt();
		}

		return b;
	}

}
