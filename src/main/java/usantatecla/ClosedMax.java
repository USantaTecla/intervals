package usantatecla;

public class ClosedMax extends Max {

  public ClosedMax(double value) {
    super(value);
  }

  @Override
  public boolean isWithin(double value) {
    return this.value >= value;
  }

}
