package usantatecla;

public class ClosedMin extends Min {

  public ClosedMin(double value) {
    super(value);
  }

  @Override
  public boolean isWithin(double value) {
    return super.isWithin(value) || this.value == value;
  }

  @Override
	public String toString() {
		return "[" + this.value;
  }	
  
}
