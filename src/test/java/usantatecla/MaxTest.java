package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static usantatecla.NumberLine.VALUE;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaxTest {
  
  protected Max max;

  @BeforeEach
  public void before(){
    this.max = new Max(NumberLine.VALUE);
  }

  @Test
  public void givenMaxWhenIsWithinWithLessValueThenTrue(){
    assertTrue(this.max.isWithin(NumberLine.less(VALUE)));
  }

  @Test
  public void givenMaxWhenIsWithinWithEqualsValue(){
    assertFalse(this.max.isWithin(NumberLine.equals(VALUE)));
  }

  @Test
  public void givenMaxWhenIsWithinWithGreaterValueThenTrue(){
    assertFalse(this.max.isWithin(NumberLine.greater(VALUE)));
  }
 
}
