package cet12_09;

public class Reditelj extends Zaposleni{

	public Reditelj(String ime, Pozoriste pozoriste) {
		super(ime, pozoriste);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String imePosla() {
		// TODO Auto-generated method stub
		return "Reditelj";
	}

}
