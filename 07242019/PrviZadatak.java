package dvacetirisedam;

import java.util.Scanner;

public class PrviZadatak {

	public static void main(String[] args) {
		int n, c;
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		c = 6 - n;
		
		switch (n) {
		case 1:
			System.out.print("Ponedeljak, do vikenda je ostalo jos " + c + " dana.");
			break;
		case 2:
			System.out.print("Utorak, do vikenda je ostalo jos " + c + " dana.");
			break;
		case 3:
			System.out.print("Sreda, do vikenda je ostalo jos " + c + " dana.");
			break;
		case 4:
			System.out.print("Cetvrtak, do vikenda je ostalo jos " + c + " dana.");
			break;
		case 5:
			System.out.print("Petak, do vikenda je ostao jos " + c + " dan.");
			break;
		case 6:
			System.out.print("Subota.");
			break;
		case 7:
			System.out.print("Nedelja.");
			break;
		default:
			System.out.println("Los unos.");break;
		}
		
	}
}
