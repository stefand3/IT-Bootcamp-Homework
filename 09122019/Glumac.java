package cet12_09;

public class Glumac extends Zaposleni{

	public Glumac(String ime, Pozoriste pozoriste) {
		super(ime, pozoriste);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String imePosla() {
		return "Glumac";
	}

}
