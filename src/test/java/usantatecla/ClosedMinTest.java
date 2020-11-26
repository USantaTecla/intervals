package usantatecla;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static usantatecla.NumberLine.VALUE;

public class ClosedMinTest extends MinTest {

  @Override
  @BeforeEach
  public void before(){
    this.min = new ClosedMin(VALUE);
  }

  @Test
  @Override
  public void givenMinWhenIsWithinWithEqualsValue(){
    assertTrue(this.min.isWithin(NumberLine.equals(VALUE)));
  }
  
}
