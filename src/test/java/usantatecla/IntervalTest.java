package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IntervalTest {
  
  @Test
  public void givenIntervaOpenOpenlwhenIncludeWithIncludedValueThenTrue(){
    assertTrue(new Interval(true, -1.7, new Max(5555.0)).include(0.0));
  }

  @Test
  public void givenIntervalOpenOpenwhenIncludeWithNotIncludedValueThenFalse(){
    assertFalse(new Interval(true, -1.7, new Max(5555.0)).include(9000.0));
  }

  @Test
  public void givenIntervalOpenOpenwhenIncludeWithLimitValueThenFalse(){
    assertFalse(new Interval(true, -1.7, new Max(5555.0)).include(5555.0));
  }

  @Test
  public void givenIntervalOpenClosewhenIncludeWithIncludedValueThenTrue(){
    assertTrue(new Interval(true, -1.7, new IncludedMax(5555.0)).include(0.0));
  }

  @Test
  public void givenIntervalOpenClosewhenIncludeWithNotIncludedValueThenFalse(){
    assertFalse(new Interval(true, -1.7, new IncludedMax(5555.0)).include(9000.0));
  }

  @Test
  public void givenIntervalOpenClosewhenIncludeWithLimitValueThenFalse(){
    assertTrue(new Interval(true, -1.7, new IncludedMax(5555.0)).include(5555.0));
  }
  
}