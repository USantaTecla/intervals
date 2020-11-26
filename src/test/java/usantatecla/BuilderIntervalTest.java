package usantatecla;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BuilderIntervalTest {
  
  @Test
  public void givenIntervalBuilderWhenOpenOpen(){
    Interval interval = new IntervalBuilder().open(2.2).open(4.4).build();
    System.out.println(interval);
    System.out.println(new Interval(new Min(2.2), new Max(4.4)));
    assertEquals(interval, new Interval(new Min(2.2), new Max(4.4)));
  }

}
