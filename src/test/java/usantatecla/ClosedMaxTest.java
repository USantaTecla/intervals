package usantatecla;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static usantatecla.NumberLine.VALUE;

public class ClosedMaxTest extends MaxTest {

  @Override
  @BeforeEach
  public void before(){
    this.max = new ClosedMax(VALUE);
  }

  @Test
  @Override
  public void givenMaxWhenIsWithinWithEqualsValue(){
    assertTrue(this.max.isWithin(NumberLine.equals(VALUE)));
  }
  
}
