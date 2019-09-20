package cet12_09;

import java.util.ArrayList;

public class Repertoar {
	private Pozoriste p;
	private ArrayList<Predstava> predstave;
	
	public Repertoar(Pozoriste p) {
		this.p = p;
		predstave = new ArrayList<Predstava>();
	}
	
	public boolean dodaj(Predstava p) {
		return predstave.add(p);
	}
	
	public boolean ukloni(String imePredstave) {
		for (int i = 0; i < predstave.size(); i++) {
			if (predstave.get(i).getNaziv() == imePredstave) {
				return predstave.remove(i) != null;
			}
		}
		return false;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(p.getNaziv() + ": [\n");
		for (Predstava p : predstave) {
			sb.append(p + "\n");
		}
		sb.append("]");
		
		return sb.toString();
	}
}
