package pon16_09;

import java.util.ArrayList;
import java.util.HashMap;

public class Zadatak2 {

	public static void main(String[] args) {
		HashMap<Integer, Integer[]> hm = new HashMap<Integer, Integer[]>();
		Integer[] brojevi = {2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
		hm.put(1, brojevi);
		
		System.out.println("Brojevi koji se ponavljaju neparan broj puta su: " + ponavljanjeNeparnihBr(hm));
	}

	public static ArrayList<Integer> ponavljanjeNeparnihBr(HashMap<Integer, Integer[]> hm){
		ArrayList<Integer> neparniBrPuta = new ArrayList<Integer>();
		
		Integer[] brojevi = hm.get(1);
		
		int count = 0;
		for (int i = 0; i < brojevi.length; i++) {
			count = 0;
			for (int j = 0; j < brojevi.length; j++) {
				if(brojevi[i] == brojevi[j])
					count++;
			}
			if(count % 2 != 0 && !neparniBrPuta.contains(brojevi[i]))
				neparniBrPuta.add(brojevi[i]);
		}

		return neparniBrPuta;
	}
}

//hm.put(1, 2);
//hm.put(2, 3);
//hm.put(3, 5);
//hm.put(4, 4);
//hm.put(5, 5);
//hm.put(6, 2);
//hm.put(7, 4);
//hm.put(8, 3);
//hm.put(9, 5);
//hm.put(10, 2);
//hm.put(11, 4);
//hm.put(12, 4);
//hm.put(13, 2);
