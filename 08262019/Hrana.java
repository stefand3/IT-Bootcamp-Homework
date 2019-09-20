package pon26_08;

public class Hrana extends Namirnica{
	private double tezina;
	private double belancevine;
	private double masti;
	private double ugljeniHidrati;
	
	public Hrana(String ime, double tezina, double belancevine, double masti, double ugljeniHidrati) {
		super(ime);
		if(belancevine + masti + ugljeniHidrati > 100) {
			System.out.println("Greska!");
			return;
		}
		else {
			this.tezina = tezina;
			this.belancevine = belancevine;
			this.masti = masti;
			this.ugljeniHidrati = ugljeniHidrati;
		}
	}
	
	
	@Override
	public double energVr() {
		double sum = 0;
		sum+= getBelancevine() * 16.7;
		sum+= getMasti() * 37.6;
		sum+=  getUgljeniHidrati() * 17.2;
		return sum; 
	}


	public double getTezina() {
		return tezina;
	}


	public double getBelancevine() {
		return (tezina*belancevine)/100;
	}


	public double getMasti() {
		return (tezina*masti)/100;
	}


	public double getUgljeniHidrati() {
		return (tezina*ugljeniHidrati)/100;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(" (" + tezina + "g, " + energVr() + "kJ)");
		
		return sb.toString();
	}
}
