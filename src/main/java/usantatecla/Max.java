package usantatecla;

public class Max {

  protected double value;

	public Max(double value) {
    this.value = value;
  }

	public boolean isOnLeft(double value) {
      return this.value > value;
	}
  
}
