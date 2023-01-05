package usantatecla.connect4.models;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ColorTest {

    @Test
    public void testGivenNewColorWhenGetThenReturn() {
        assertThat(Color.get(0), is(Color.RED));
        assertThat(Color.get(1), is(Color.YELLOW));
    }


    @Test
    public void testGivenColorWhenIsNullThenReturn() {
        assertThat(Color.RED.isNull(), is(false));
        assertThat(Color.YELLOW.isNull(), is(false));
        assertThat(Color.NULL.isNull(), is(true));
    }
}
