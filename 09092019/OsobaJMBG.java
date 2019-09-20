package pon09_09;

import java.util.Date;

public class OsobaJMBG extends Osoba{
	
	private String JMBG;
	
	public OsobaJMBG(String ime, String prezime, String adresa, String JMBG) {
		super(ime, prezime, adresa);
			this.JMBG = JMBG;
	}
	
	public OsobaJMBG(OsobaJMBG oj) {
		super(oj);
		this.JMBG = oj.JMBG;
	}
	
	@Override
	public int numeroloskiBroj() {
		String s = "";
		int dan = Integer.parseInt(JMBG.substring(0, 2));
		int mesec = Integer.parseInt(JMBG.substring(2, 4));
		int godina = Integer.parseInt("1" + JMBG.substring(4, 7));
		
		s = dan + "" + mesec + godina;
		int sum = 0, value = 0;
		
		for (int i = 0; i < s.length(); i++) {
			sum += Character.getNumericValue(s.charAt(i));
		}
		if(sum > 9) {
			value += sum % 10;
			sum /= 10;
			value += sum % 10;
		}
		
		return value;
	}

	@Override
	public String metabolizam(final Datum d) {
		String str = JMBG.substring(0,4) + "1" + JMBG.substring(4, 7);
		
		String[]n = d.toString().split("\\.");
		String s = "";
		
		
		if(n[0].length() == 1) {
			n[0] = "0" + n[0];
		}
		if(n[1].length() == 1) {
			n[1] = "0" + n[1];
		}
		for (int i = 0; i < n.length; i++) {
			s += n[i];
		}
		
		for (int i = 0; i < n.length; i++) {
			int t = Integer.parseInt(s) + Integer.parseInt(str);
			return Integer.toString(t);
		}
		return "";
	}
}
