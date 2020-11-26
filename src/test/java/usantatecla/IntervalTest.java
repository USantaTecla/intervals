package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import static usantatecla.NumberLine.VALUE;

public class IntervalTest {

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWithIncludedValueThenTrue() {
    assertTrue(new Interval(true, -1.7, new Max(VALUE)).include(NumberLine.less(VALUE)));
    assertFalse(new Interval(true, -1.7, new Max(VALUE)).include(NumberLine.equals(VALUE)));
    assertFalse(new Interval(true, -1.7, new Max(VALUE)).include(NumberLine.greater(VALUE)));
    assertTrue(new Interval(true, -1.7, new ClosedMax(VALUE)).include(NumberLine.less(VALUE)));
    assertTrue(new Interval(true, -1.7, new ClosedMax(VALUE)).include(NumberLine.equals(VALUE)));
    assertFalse(new Interval(true, -1.7, new ClosedMax(VALUE)).include(NumberLine.greater(VALUE)));
  }

}