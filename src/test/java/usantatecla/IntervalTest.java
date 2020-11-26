package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IntervalTest {
  
  @Test
  public void givenIntervaOpenOpenlwhenIncludeWithIncludedValueThenTrue(){
    assertTrue(new Interval(true, -1.7, new Max(5555.0)).include(0.0));
    assertFalse(new Interval(true, -1.7, new Max(5555.0)).include(9000.0));
    assertFalse(new Interval(true, -1.7, new Max(5555.0)).include(5555.0));
    assertTrue(new Interval(true, -1.7, new ClosedMax(5555.0)).include(0.0));
    assertFalse(new Interval(true, -1.7, new ClosedMax(5555.0)).include(9000.0));
    assertTrue(new Interval(true, -1.7, new ClosedMax(5555.0)).include(5555.0));
  }
  
}