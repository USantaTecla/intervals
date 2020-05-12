package usantatecla;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IntervalTest {
  
  @Test
  public void givenIntervalwhenIncludeWithIncludedValueThenTrue(){
    assertTrue(new Interval(-1.7,5555.0).include(0.0));
  }
  
}