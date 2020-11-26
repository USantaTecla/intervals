package usantatecla;

public class Interval {

	private double min;
	private double max;

	public Interval(double d, double e) {
		this.min = d;
		this.max = e;
	}

	public boolean include(double d) {
		return this.min <= d && d <= this.max;
	}


}