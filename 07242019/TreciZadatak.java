package dvacetirisedam;

import java.util.Scanner;

public class TreciZadatak {

	public static void main(String[] args) {
		String n;
		double a, b, r;
		Scanner sc = new Scanner(System.in);

		System.out.print("Unesite ime figure: ");
		n = sc.nextLine();
		
		switch(n) {
		case "kvadrat" : 
			System.out.print("Unesite stranicu: ");
			a = sc.nextDouble();
			System.out.println("Povrsina iznosi: " + a*a + ", Obim iznosi: " + 4*a);break;
			
		case "pravougaonik" : 
			System.out.print("Unesite stranicu a: ");
			a = sc.nextDouble();
			System.out.print("Unesite stranicu b: ");
			b = sc.nextDouble();
			System.out.println("Povrsina iznosi: " + a*b + ", Obim iznosi: " + (2*a+2*b));break;
			
		case "krug" : 
			System.out.print("Unesite poluprecnik: ");
			r = sc.nextDouble();
			System.out.println("Povrsina iznosi: " + r*r*Math.PI + ", Obim iznosi: " + 2*r*Math.PI);break;
		
		default : System.out.println("Pogresan unos");break;
		}

	}
}
