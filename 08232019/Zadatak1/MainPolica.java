package pet23_08;

public class MainPolica {

	public static void main(String[] args) {
		List l1 = new List("11111111111111", 1);
		List l2 = new List("22222222222222", 2);
		List l3 = new List("33333333333333", 3);
		List l4 = new List("44444444444444", 4);
		List l5 = new List("55555555555555", 5);
		
		Knjiga k1 = new Knjiga("Knjiga1");
		k1.dodajlist(l1);
		k1.dodajlist(l2);
		k1.dodajlist(l3);
		k1.dodajlist(l4);
		k1.dodajlist(l5);
		
		Knjiga k2 = new Knjiga("Knjiga2");
		k2.dodajlist(l1);
		k2.dodajlist(l2);
		k2.dodajlist(l3);
		k2.dodajlist(l4);
		k2.dodajlist(l5);
		
		Knjiga k3 = new Knjiga("Knjiga3");
		k3.dodajlist(l1);
		k3.dodajlist(l2);
		k3.dodajlist(l3);
		k3.dodajlist(l4);
		k3.dodajlist(l5);
		
		Polica p = new Polica();
		p.dodajKnjigu(k1);
		p.dodajKnjigu(k2);
		p.dodajKnjigu(k3);

		System.out.println(p);
	}

}
