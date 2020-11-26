package usantatecla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static usantatecla.NumberLine.VALUE;

public class MinTest {
  
  protected Min min;

  @BeforeEach
  public void before(){
    this.min = new Min(NumberLine.VALUE);
  }

  @Test
  public void givenMinWhenIsWithinWithLessValueThenTrue(){
    assertFalse(this.min.isWithin(NumberLine.less(VALUE)));
  }

  @Test
  public void givenMinWhenIsWithinWithEqualsValue(){
    assertFalse(this.min.isWithin(NumberLine.equals(VALUE)));
  }

  @Test
  public void givenMinWhenIsWithinWithGreaterValueThenTrue(){
    assertTrue(this.min.isWithin(NumberLine.greater(VALUE)));
  }
 
}

