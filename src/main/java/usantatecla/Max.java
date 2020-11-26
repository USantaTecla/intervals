package usantatecla;

public class Max {

  private double value;
  private boolean open;

	public Max(boolean b, int i) {
    this.value = i;
    this.open = b;
  }

	public boolean greater(double d) {
    if (this.open){
      return this.value > d;
    }
    return this.value >= d;
	}
  
}
