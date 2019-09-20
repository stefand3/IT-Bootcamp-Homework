package pon16_09;

import java.util.ArrayList;
import java.util.HashMap;

public class Zadatak3 {

	public static void main(String[] args) {
		ArrayList<String> svaDeca = new ArrayList<String>();
		ArrayList<String> dobraDeca = new ArrayList<String>();
		
		svaDeca.add("Mile");
		svaDeca.add("Joca");
		svaDeca.add("Dule");
		svaDeca.add("Mare");
		svaDeca.add("Stefan");
		
		dobraDeca.add("Stefan");
		dobraDeca.add("Stefan");
		dobraDeca.add("Mare");
		dobraDeca.add("Stefan");
		dobraDeca.add("Mare");
		dobraDeca.add("Joca");
		
		
		// Ispis celog spiska
		//System.out.println(dobraDela(svaDeca, dobraDeca));
		
		HashMap<String, Integer> hm = dobraDela(svaDeca, dobraDeca);
		// Ispis dobre dece i broja dobrih dela
		for(String s : hm.keySet()) {
			if(dobraDeca.contains(s)) {
				System.out.println(s + " " + hm.get(s));
			}
		}
	}

	public static HashMap<String, Integer> dobraDela(ArrayList<String> svaDeca, ArrayList<String> dobraDeca){
		HashMap<String, Integer> hm = new HashMap<String,Integer>();
		
		// Ubacuje svu decu i stavlja default vrednost 0
		for(String s : svaDeca) {
			hm.put(s, 0);
		}
		// Stavlja vrednost +1 za one koji su ucinili dobro delo
		for(String s : dobraDeca) {
			Integer i = hm.get(s);
			if (hm.containsKey(s)) {
				hm.replace(s, ++i);
			}
		}
		return hm;
	}
}
