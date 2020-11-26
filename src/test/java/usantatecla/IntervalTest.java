package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IntervalTest {

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWithIncludedValueThenTrue() {
    Point right = new Point(4.4);
    assertTrue(new Interval(true, -1.7, new Max(right.getEquals())).include(right.getLess()));
    assertFalse(new Interval(true, -1.7, new Max(right.getEquals())).include(right.getEquals()));
    assertFalse(new Interval(true, -1.7, new Max(right.getEquals())).include(right.getGreater()));
    assertTrue(new Interval(true, -1.7, new ClosedMax(right.getEquals())).include(right.getLess()));
    assertTrue(new Interval(true, -1.7, new ClosedMax(right.getEquals())).include(right.getEquals()));
    assertFalse(new Interval(true, -1.7, new ClosedMax(right.getEquals())).include(right.getGreater()));
  }

}