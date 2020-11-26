package usantatecla;

public class ClosedMax extends Max {

  public ClosedMax(double value) {
    super(value);
  }

  @Override
  public boolean isWithin(double value) {
    return super.isWithin(value) || this.value == value;
  }

  @Override
	public String toString() {
		return this.value + "]";
	}	

}
