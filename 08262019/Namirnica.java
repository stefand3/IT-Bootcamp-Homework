package pon26_08;

import java.util.Random;

public abstract class Namirnica extends Energent{
	private Random rd = new Random();
	private String ime;
	static int uid = 1;
	private int id;
	
	public Namirnica(String ime) {
		this.ime = ime;
		this.id = uid++;
	}

	public String getIme() {
		return ime;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[" + id +"] " + ime);
		
		return sb.toString();
	}
	
	  
}
