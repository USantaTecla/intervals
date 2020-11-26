package usantatecla;

public class Interval {

	private double min;
	private double max;

	public Interval(double min, double max) {
		assert min <= max;
		this.min = min;
		this.max = max;
	}

	public boolean include(double value) {
		return this.min <= value && value <= this.max;
	}

}