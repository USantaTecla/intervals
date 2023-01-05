package usantatecla.utils;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DirectionTest {

    @Test
    public void test() {
        assertThat(Direction.NORTH.next().equals(Direction.NORTH_EAST), is(true));
        assertThat(Direction.NORTH_WEST.next().equals(Direction.NORTH), is(true));
    }

    @Test
    public void test2() {
        assertThat(Direction.NORTH.getOpposite().equals(Direction.SOUTH), is(true));
        assertThat(Direction.NORTH_WEST.getOpposite().equals(Direction.SOUTH_EAST), is(true));
    }

    @Test
    public void test3() {
        assertThat(Direction.NORTH.next(new Coordinate(-1, 0)).equals(new Coordinate(0, 0)), is(true));
        assertThat(Direction.NORTH_WEST.next(new Coordinate(0, 0)).equals(new Coordinate(1, -1)), is(true));
    }
}
