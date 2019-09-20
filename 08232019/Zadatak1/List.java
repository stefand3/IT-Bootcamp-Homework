package pet23_08;

public class List {
	private String text;
	private int rBr;
	
	
	
	public List(String text, int rBr) {
		this.text = text;
		this.rBr = rBr;
	}


	public int getrBr() {
		return rBr;
	}
	
	
	public void setText(String text) {
		this.text = text;
	}


	public static int poredjenje(List a, List b) {
		if(a.rBr > b.rBr)
			return a.rBr;
		else
			return b.rBr;
	}
	
	public int poredjenje(List a) {
		if(this.rBr > a.rBr)
			return this.rBr;
		else
			return a.rBr;
	}


	@Override
	public String toString() {
		return text + "(" + rBr +")";
	}
	
	
}
