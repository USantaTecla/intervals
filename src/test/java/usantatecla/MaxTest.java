package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MaxTest {
   
  protected static final double VALUE = 4.4;
  private static final double DEVIATION = 0.1;

  public Max createMax(double value){
    return new Max(value);
  }

  @Test
  public void givenMaxWhenIsWithinWithLessValueThenTrue(){
    assertTrue(createMax(VALUE).isWithin(less(VALUE)));
  }

  @Test
  public void givenMaxWhenIsWithinWithEqualsValue(){
    assertFalse(createMax(VALUE).isWithin(equals(VALUE)));
  }

  @Test
  public void givenMaxWhenIsWithinWithGreaterValueThenTrue(){
    assertFalse(createMax(VALUE).isWithin(greater(VALUE)));
  }

  protected double less(double value) {
    return value - MaxTest.DEVIATION;
  }

  protected double equals(double value) {
    return value;
  }

  protected double greater(double value) {
    return value + MaxTest.DEVIATION;
  }
 
}
