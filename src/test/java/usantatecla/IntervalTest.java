package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IntervalTest {
  
  private Point left = new Point(-2.2);
  private Point right = new Point(4.4);
  
  @Test
  public void givenIntervaOpenOpenlwhenIncludeWithIncludedValueThenTrue() {
    assertFalse(new Interval(new Min(left.getEquals()), new Max(right.getEquals())).include(left.getLess()));
    assertFalse(new Interval(new Min(left.getEquals()), new Max(right.getEquals())).include(left.getEquals()));
    assertTrue(new Interval(new Min(left.getEquals()), new Max(right.getEquals())).include(left.getGreater()));

    assertTrue(new Interval(new Min(left.getEquals()), new Max(right.getEquals())).include(right.getLess()));
    assertFalse(new Interval(new Min(left.getEquals()), new Max(right.getEquals())).include(right.getEquals()));
    assertFalse(new Interval(new Min(left.getEquals()), new Max(right.getEquals())).include(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenInc3ludeWithIncludedValueThenTrue() {
    assertFalse(new Interval(new ClosedMin(left.getEquals()), new Max(right.getEquals())).include(left.getLess()));
    assertTrue(new Interval(new ClosedMin(left.getEquals()), new Max(right.getEquals())).include(left.getEquals()));
    assertTrue(new Interval(new ClosedMin(left.getEquals()), new Max(right.getEquals())).include(left.getGreater()));

    assertTrue(new Interval(new ClosedMin(left.getEquals()), new Max(right.getEquals())).include(right.getLess()));
    assertFalse(new Interval(new ClosedMin(left.getEquals()), new Max(right.getEquals())).include(right.getEquals()));
    assertFalse(new Interval(new ClosedMin(left.getEquals()), new Max(right.getEquals())).include(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWit3hIncludedValueThenTrue() {
    assertFalse(new Interval(new Min(left.getEquals()), new ClosedMax(right.getEquals())).include(left.getLess()));
    assertFalse(new Interval(new Min(left.getEquals()), new ClosedMax(right.getEquals())).include(left.getEquals()));
    assertTrue(new Interval(new Min(left.getEquals()), new ClosedMax(right.getEquals())).include(left.getGreater()));

    assertTrue(new Interval(new Min(left.getEquals()), new ClosedMax(right.getEquals())).include(right.getLess()));
    assertTrue(new Interval(new Min(left.getEquals()), new ClosedMax(right.getEquals())).include(right.getEquals()));
    assertFalse(new Interval(new Min(left.getEquals()), new ClosedMax(right.getEquals())).include(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWithInclude5dValueThenTrue() {
    assertFalse(new Interval(new ClosedMin(left.getEquals()), new ClosedMax(right.getEquals())).include(left.getLess()));
    assertTrue(new Interval(new ClosedMin(left.getEquals()), new ClosedMax(right.getEquals())).include(left.getEquals()));
    assertTrue(new Interval(new ClosedMin(left.getEquals()), new ClosedMax(right.getEquals())).include(left.getGreater()));

    assertTrue(new Interval(new ClosedMin(left.getEquals()), new ClosedMax(right.getEquals())).include(right.getLess()));
    assertTrue(new Interval(new ClosedMin(left.getEquals()), new ClosedMax(right.getEquals())).include(right.getEquals()));
    assertFalse(new Interval(new ClosedMin(left.getEquals()), new ClosedMax(right.getEquals())).include(right.getGreater()));
  }

}