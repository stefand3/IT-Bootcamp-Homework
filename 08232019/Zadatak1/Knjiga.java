package pet23_08;

public class Knjiga {
	private String naziv;
	public List[] listovi;
	private int brListova = 0;

	public Knjiga(String naziv) {
		this.naziv = naziv;
		listovi = new List[5];
	}

	public void dodajlist(List l) {
		if(brListova >= listovi.length)
			return;
		
		listovi[brListova] = l;
		brListova++;
//		for (int i = 0; i < listovi.length; i++) {
//			if (listovi[i] == null || listovi[i].getrBr() == l.getrBr()) { // Ako postoji sa istim rBr zamenjuje ga
//				listovi[brListova] = l;
//				brListova++;
//			}
//
//			else if (listovi[brListova] == null) {// Ako ne psotoji dodaje redom
//				listovi[brListova] = l;
//				brListova++;
//			}
//				
//			else if (listovi[brListova] != null)
//				continue;
//		}
	}

	public String getNaziv() {
		return naziv;
	}

	public int getBrListova() {
		return brListova;
	}

	public List getList(int br) {
		for (int i = 0; i < listovi.length; i++) {
			if (listovi[i].getrBr() == br) {
				return listovi[i];
			}
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(naziv + "\n");
		
		int i = 1;
		for(List list : listovi) {
			if(list != null) {
				sb.append("\t" + i + ". " + list + "\n");
			}
			i++;
		}
		
		return sb.toString();
	}
	
	
}
