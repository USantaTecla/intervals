package usantatecla;

public class Max {

  double value;
  boolean open;

	public Max(double value, boolean open) {
    this.value = value;
    this.open = open;
  }

	public boolean greaterOrEquals(double value) {
    if (this.open){
      return this.value > value;
    }
    return this.value >= value;
	}
  
}
