package cet15_08;

public class Main {

	public static void main(String[] args) {
		Pravougaonik prviP = new Pravougaonik(5, 6, "Pravougaonik A");
		Pravougaonik drugiP = new Pravougaonik(3, "Pravougaonik B");
	
		System.out.println("Stranica 'a' Pravougaonika A je: " + prviP.getA());
		System.out.println("Stranica 'b' Pravougaonika A je: " + prviP.getB());
		System.out.println("-------------------------------------------------");
		System.out.println("Stranica 'a' Pravougaonika B je: " + drugiP.getA());
		System.out.println("Stranica 'b' Pravougaonika B je: " +  drugiP.getB());
		System.out.println("-------------------------------------------------");
		System.out.println(prviP.ispisPravougaonika());
		System.out.println("-------------------------------------------------");
		System.out.println(drugiP.ispisPravougaonika());
	}

}
