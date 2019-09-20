package dvanaestiosmi;

import java.util.Random;
import java.util.Scanner;

public class Zadatak {

	static void ispisIMatricu(int[][] matrica) {

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite broj redova matrice: ");
		int n = sc.nextInt();
		System.out.println("Unesite broj kolona matrice: ");
		int m = sc.nextInt();
		int[][] matrica = new int[n][m];
		
		System.out.println("Unesite elemente: ");
		for (int i = 0; i < matrica.length; i++) {
			for (int j = 0; j < matrica[i].length; j++) {
				matrica[i][j] = sc.nextInt();
			}
		}
		
		ispisiMatricu(matrica);
		ispisiNiz(matrica[0]);
		//generisiElementeMatrice(matrica, 5);
		int[] glavnaDijagonala = elementiNaGlavnojDijagonali(matrica);
		int[] sporednaDijagonala = elementiNaSporednojDijagonali(matrica);
		int[][] transponovanaMatrica = transponujMatricu(matrica);
		ispisiElementeIznadGlavneDijagonale(matrica);
		ispisiElementeIspodGlavneDijagonale(matrica);
		
		int[] niz = { 1, 56, 3, 3, 10, 11, 6, 6, 71, 71, 88 };
		int[] rezultat = ukloniElementeKojiSePonavljajuUnizu(niz);
	}

	static int[] elementiNaGlavnojDijagonali(int[][] matrica) {
		int[] glavnaDijagonala = new int[matrica.length];

		for (int i = 0; i < glavnaDijagonala.length; i++) {
			glavnaDijagonala[i] = matrica[i][i];
		}
		return glavnaDijagonala;
	}

	static int[] elementiNaSporednojDijagonali(int[][] matrica) {
		int[] sporednaDijagonala = new int[matrica.length];
		int m = matrica.length - 1;
		for (int i = 0; i < sporednaDijagonala.length; i++, m--) {
			sporednaDijagonala[i] = matrica[i][m];
		}
		return sporednaDijagonala;
	}

	static int[][] transponujMatricu(int[][] matrica) {
		int[][] transponovanaMatrica = new int[matrica.length][matrica[0].length];

		for (int i = 0; i < matrica.length; i++) {
			for (int j = 0; j < matrica.length; j++) {
				transponovanaMatrica[i][j] = matrica[j][i];
			}
		}
		return transponovanaMatrica;
	}

	static void ispisiElementeIznadGlavneDijagonale(int[][] matrica) {
		int[] rezultat = new int[matrica.length - 1];
		int n = rezultat.length;

		System.out.print("Elementi iznad glavne dijagonale su: ");
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n + 1; j++) {
				rezultat[i] = matrica[i][j];
				System.out.print(rezultat[i] + " ");
			}
		}
		System.out.println();
	}

	static void ispisiElementeIspodGlavneDijagonale(int[][] matrica) {
		int[] rezultat = new int[matrica.length];

		System.out.print("Elementi ispod glavne dijagonale su: ");
		for (int i = 1; i <= matrica.length - 1; i++) {
			for (int j = 0; j < i; j++) {
				rezultat[i] = matrica[i][j];
				System.out.print(rezultat[i] + " ");
			}
		}
		System.out.println();
	}

	public static void ispisiMatricu(int[][] matrica) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < matrica.length; i++) {
			for (int j = 0; j < matrica[i].length; j++) {
				System.out.print(matrica[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void ispisiNiz(int[] niz) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < niz.length; i++) {
			System.out.print(niz[i] + " ");
		}
	}

	static int[] ukloniElementeKojiSePonavljajuUnizu(int[] niz) {
		int brojac = 0;
		for (int i = 0; i < niz.length; i++) {
			for (int j = i + 1; j < niz.length; j++) {
				if (niz[i] == niz[j]) {
					brojac++;
					break;
				}
			}
		}
		int[] rezultat = new int[niz.length - brojac];
		int k = 0;
		boolean flag = false;

		for (int i = 0; i < niz.length; i++) {
			flag = true;
			for (int j = i + 1; j < niz.length; j++) {
				if (niz[i] == niz[j]) {
					flag = false;
				}
			}
			if (flag == true) {
				rezultat[k] = niz[i];
				k++;
			}
		}
		for (int i = 0; i < rezultat.length; i++) {
			System.out.print(rezultat[i] + " ");
		}
		return rezultat;
	}

//	static void generisiElementeMatrice(int[][] matrica, int gornjagranica) {
//	Random rd = new Random();
//
//	for (int i = 0; i < matrica.length; i++) {
//		for (int j = 0; j < matrica.length; j++) {
//			matrica[i][j] = rd.nextInt(gornjagranica);
//		}
//	}
//}
}

