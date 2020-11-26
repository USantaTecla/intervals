package usantatecla;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MaxTest {
   
  @Test
  public void givenIntervalwhenIncludeWithIncludedValueThenTrue(){
    assertTrue(new Max(true, 4).greater(0.0));
  }
 
}
