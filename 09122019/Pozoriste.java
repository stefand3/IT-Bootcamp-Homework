package cet12_09;

public class Pozoriste {
	private String naziv;
	static int id = 0;
	private int uid;
	
	public Pozoriste(String naziv) {
		this.naziv = naziv;
		uid = id++;
	}

	public String getNaziv() {
		return naziv;
	}

	public static int getId() {
		return id;
	}

	public String getSkraceniNaziv() {
		String[] s = naziv.split(" ");
		String ss = "";
		for (int i = 0; i < s.length; i++) {
			ss += s[i].charAt(0);
		}
		return ss.toUpperCase();
	}
	
	public String toString() {
		return naziv + "[" + uid + "]";
	}
	
	
}
