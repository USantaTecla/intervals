package usantatecla;

public class Max {

  protected double value;

	public Max(double value) {
    this.value = value;
  }

	public boolean isWithin(double value) {
      return this.value > value;
	}
  
}
