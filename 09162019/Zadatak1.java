package pon16_09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Zadatak1 {

	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("Aleksa", 23);
		hm.put("Bilja", 1);
		hm.put("Jovica", 35);
		hm.put("Katarina", 20);
		hm.put("Svetlana", 19);

		System.out.println(sortiraj(hm));
	}

	public static String sortiraj(HashMap<String, Integer> hm) {
		ArrayList<String> arrayList = new ArrayList<String>();
		for(String s : hm.keySet()) {
			arrayList.add(s);
		}
		Collections.sort(arrayList);
		
		StringBuilder sb = new StringBuilder();
		for(String s : arrayList) {
			sb.append(s + " " + hm.get(s) + "\n");
		}
		
		return sb.toString();
	}
}
