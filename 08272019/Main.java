package uto27_08;

import java.util.Date;
import java.lang.Object;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
	public static void main(String[] args) {
		//Album love_supreme =  new Album("A love Supreme", "John Coltrane", new Date(1965-01-23));
		Album love_supreme = new Album("A love Supreme", "John Coltrane",  new GregorianCalendar(1965, Calendar.FEBRUARY, 12).getTime());
		love_supreme.dodaj("Part I: Acknowledgement", "7:42");
		love_supreme.dodaj("Part II: Resolution", "7:19");
		love_supreme.dodaj("Part III: Pursuance", "10:41");
		love_supreme.dodaj("Part IV: Psalm", "7:02");
//		System.out.println(love_supreme);
		
		
		Album animals = new Album("Animals", "Pink Floyd", new GregorianCalendar(1977, Calendar.JANUARY, 23).getTime());
		animals.dodaj("Pigs on the wing 1", "1:25");
		animals.dodaj("Dogs", "17:05");
		animals.dodaj("Pigs (three different ones)", "11:26");
		animals.dodaj("Sheep", "10:18");
		animals.dodaj("Pigs on the wing 2", "1:28");
//		System.out.println(animals);
		
		Prodavnica p = new Prodavnica("Music Shop", "Koltrejnova 7");
		p.dodaj(new LP(love_supreme, "Impulse! Records", 2750, 0, 120));
		p.dodaj(new LP(love_supreme, "Impulse! Records", 3110, 7, 180));
		p.dodaj(new CD(love_supreme, "Impulse! Records", 1500, 40));
		p.dodaj(new LP(animals, "Pink Floyd Records", 2500, 7, 12)); // Pink Floyd Records
		p.dodaj(new CD(animals, "Pink Floyd Records", 1250, 30));
		
		System.out.println(p + "");
		
		simulacija(p, "Pink Floyd");
		simulacija(p, "David Bowie");
		simulacija(p, "colTrane");
		System.out.println(p);
	}
	
	public static void simulacija(Prodavnica p, String zelja) {
		System.out.println("-- Kupac ulazi u radnju! --");
		System.out.println("Kupac: Dobar dan zeleo bih da kupim nesto od " + zelja + "-a!");
		Artikal[] ponuda = p.pretrazi(zelja);
		if(ponuda.length == 0) {
			System.out.println("Prodavac: Nazalost nemamo to u ponudi :(");
			System.out.println("Kupac: Ih prava steta, vidimo se neki drugi put!");
		}
		else {
			System.out.println("Prodavac: Pozdrav, od " + zelja + "-a imamo u ponudi: ");
			for (int i = 0; i < ponuda.length; i++) {
				if(ponuda[i] != null) {
					System.out.println("  " + ponuda[i]);
				}
			}
			
			boolean kupio = false;
			int k = 0;
			while(ponuda[k] != null && ponuda.length > k && !kupio) {
//				if(ponuda[k] != null) {
//					System.out.println("Kupac: kupicu -- " + ponuda[k].ime());
//					kupio = ponuda[k++].kupi();
//				}
				System.out.println("Kupac: Kupicu -- " + ponuda[k].ime());
				kupio = ponuda[k++].kupi();
				if(!kupio) {
					System.out.print("Prodavac: ");
					System.out.println("Nazalost nemamo trazeni artikal trenutno!");
				}
			}
			if(kupio) {
				System.out.println("Prodavac: Izvolite");
				System.out.println("Kupac: Hvala lepo, vidimo se sledeceg meseca kad legne plata");
			}
			else {
				System.out.println("Kupac: Ih, bas steta. Vidimo se za nedelju dana");
			}
		}
		System.out.println();
	}
}
