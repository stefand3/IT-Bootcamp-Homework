package pet16_08;

public class Tacka {
	private double x;
	private double y;
	
	public Tacka(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public String ispisTacke() {
		String s = x + ", " + y;
		
		return s;
	}
}
