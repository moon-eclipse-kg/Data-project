package dataModels;

public enum RGBColor {
	
	BLACK(0),
	RED(255, 0, 0),
	GREEN(0, 255, 0),
	BLUE(0, 0, 255),
	YELLOW(255, 255, 0),
	CYAN(0, 255, 255),
	PURPLE(255, 0, 255),
	WHITE(255),
	ORANGE(255,140,0);
	
	private final double r;
	private final double g;
	private final double b;
	
	private RGBColor(double c) {
		this(c, c, c);
	}
	
	private RGBColor(double r, double g, double b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public double getR() {
		return r;
	}
	
	public double getG() {
		return g;
	}
	
	public double getB() {
		return b;
	}
	
	public double[] get() {
		return new double[] {r, g, b};
	}	
	
}
