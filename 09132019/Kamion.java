package pet13_09;

import java.util.ArrayList;

public class Kamion {
	private String regBr;
	private double nosivost;
	private double teret;
	private ArrayList<Tovar> tovar;
	
	//stvara se prazan
	public Kamion (String regBr, double nosivost){
		this.nosivost = nosivost;
		this.regBr = regBr;
		teret = 0;
		tovar = new ArrayList<Tovar>();
	}
	
	public boolean stavi(Tovar t) {
		teret += t.tezina();
		return tovar.add(t);
	}
	
	public boolean skini(int poz) {
		teret -= tovar.get(poz).tezina();
		return tovar.remove(tovar.get(poz));
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(regBr + "(" + teret + "/" + nosivost + ")");
		for(Tovar t : tovar) {
			sb.append("\n" + t);
		}
		
		return sb.toString();
	}
}
