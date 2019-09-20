package pon26_08;

public class Meni {
	private Namirnica[] namirnice;
	private int brNam = 0;
	
	public Meni(int n) {
		namirnice = new Namirnica[n];
	}
	
	public void dodaj(Namirnica n) {
		if(namirnice[brNam] == null && brNam < namirnice.length)
			namirnice[brNam++] = n;
		else
			return;
	}
	
	public double energVr() {
		double rez = 0;
		
		for (Namirnica n : namirnice) {
			if(n != null)
				rez += n.energVr();
		}
		return rez;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Meni: " + energVr() + "kJ");
		
		int i = 1;
		for (Namirnica n : namirnice) {
			if(n != null) {
				sb.append("\n"+ n);
			}
		}
		return sb.toString();
	}
}
