package pon09_09;

import java.util.Date;

public class OsobaD extends Osoba{
	private Datum datum;
	
	public OsobaD(String ime, String prezime, String adresa, Datum datum) {
		super(ime, prezime, adresa);
		this.datum = datum;
	}

	public OsobaD(OsobaD od)
	{
		super(od);
		this.datum = od.datum;
	}
	
	@Override
	public int numeroloskiBroj() {
		String s = "";
		s = datum.getDan() + "" + datum.getMesec() + datum.getGodina();
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
		String[] n = datum.toString().split("\\.");
		String[] n2 = d.toString().split("\\.");
		String s = "";
		String s2 = "";
		
		
		if(n[0].length() == 1) {
			n[0] = "0" + n[0];
		}
		if(n[1].length() == 1) {
			n[1] = "0" + n[1];
		}
		for (int i = 0; i < n.length; i++) {
			s += n[i];
		}
		
		if(n2[0].length() == 1) {
			n2[0] = "0" + n2[0];
		}
		if(n2[1].length() == 1) {
			n2[1] = "0" + n2[1];
		}
		for (int i = 0; i < n2.length; i++) {
			s2 += n2[i];
		}
		
		for (int i = 0; i < n.length; i++) {
			int t = Integer.parseInt(s) + Integer.parseInt(s2);
			return Integer.toString(t);
		}
		return "";
	}

	public int brNula() {
		
		
		return 1;
	}
}
