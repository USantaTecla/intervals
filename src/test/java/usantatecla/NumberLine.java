package usantatecla;

public class NumberLine {

  static final double VALUE = 4.4;
  static final double DEVIATION = 0.1;

  static double less(double value) {
    return value - NumberLine.DEVIATION;
  }

  static double equals(double value) {
    return value;
  }

  static double greater(double value) {
    return value + NumberLine.DEVIATION;
  }
}
