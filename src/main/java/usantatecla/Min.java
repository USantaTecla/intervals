package usantatecla;

public class Min {

  protected double value;

	public Min(double value) {
    this.value = value;
  }

	public boolean isWithin(double value) {
      return this.value < value;
	}
  
}
