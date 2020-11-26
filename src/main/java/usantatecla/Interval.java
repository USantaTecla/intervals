package usantatecla;

public class Interval {

	private double min;
	private Max max;

	public Interval(boolean minOpen, double min, Max max) {
		assert min <= max.value;
		this.min = min;
		this.max = max;
	}

	public boolean include(double value) {
			return this.min <= value && this.max.greaterOrEquals(value);
	}

}