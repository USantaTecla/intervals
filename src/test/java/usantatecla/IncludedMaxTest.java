package usantatecla;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IncludedMaxTest extends MaxTest {

  @Override
  public Max createMax(double value){
    return new ClosedMax(value);
  }

  @Test
  @Override
  public void givenMaxWhenIsWithinWithEqualsValue(){
    assertTrue(createMax(VALUE).isWithin(equals(VALUE)));
  }
  
}
