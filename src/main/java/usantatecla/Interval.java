package usantatecla;

public class Interval {

	private double min;
	private double max;
	private boolean maxOpen;

	public Interval(boolean minOpen, double min, boolean maxOpen, double max) {
		assert min <= max;
		this.min = min;
		this.maxOpen = maxOpen; 
		this.max = max;
	}

	public boolean include(double value) {
		if (this.maxOpen){
			return this.min <= value && value < this.max;
		}
		return this.min <= value && value <= this.max;
	}

}