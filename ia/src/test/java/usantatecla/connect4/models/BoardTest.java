package usantatecla.connect4.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardTest {

    private BoardBuilder boardBuilder;

    @BeforeEach
    public void beforeEach() {
        this.boardBuilder = new BoardBuilder();
    }

    @Test
    public void testGivenEmptyBoardWhenStartThenIsEmpty() {
        Board board = this.boardBuilder.build();
        assertThat(board.isComplete(), is(false));
        assertThat(board.isComplete(0), is(false));
        assertThat(board.isComplete(Board.COLUMNS - 1), is(false));
    }

    @Test
    public void testGivenNewBoardWhenPutNewTokenThenIsOccupiedIsTrue2() {
        Board board = this.boardBuilder.rows(" 0123456",
                "5R      ",
                "4Y      ",
                "3R      ",
                "2Y      ",
                "1R      ",
                "0Y      ").build();
        assertThat(board.isComplete(), is(false));
        assertThat(board.isComplete(0), is(true));
        assertThat(board.isComplete(Board.COLUMNS - 1), is(false));
    }

    @Test
    public void testGivenNewBoardWhenPutsNewTokenThenIsOccupiedIsTrue2() {
        Board board = this.boardBuilder.rows(" 0123456",
                "5RYRYRYR",
                "4YRYRYRY",
                "3RYRYRYR",
                "2YRYRYRY",
                "1RYRYRYR",
                "0YRYRYRY").build();
        assertThat(board.isComplete(), is(true));
        assertThat(board.isComplete(0), is(true));
        assertThat(board.isComplete(Board.COLUMNS - 1), is(true));
    }
    
    @Test
    public void testGivenBoardWhenMoveXTokenOriginIsEmptyAndTargetIsOccupiedThenIsTrue() {
        Board board = this.boardBuilder.rows(" 0123456",
                "5       ",
                "4       ",
                "3       ",
                "2       ",
                "1YYY    ",
                "0RRR    ").build();
        board.dropToken(3, Color.RED);
        assertThat(board.isWinner(), is(true));
    }

    @Test
    public void testGivenBoardWhenMovseXTokenOriginIsEmptyAndTargetIsOccupiedThenIsTrue() {
        Board board = this.boardBuilder.rows(" 0123456",
                "5       ",
                "4       ",
                "3       ",
                "2RY     ",
                "1RY     ",
                "0RY     ").build();
        board.dropToken(0, Color.RED);
        assertThat(board.isWinner(), is(true));
    }

    @Test
    public void testGivenBoardWhenMovsesXTokenOriginIsEmptyAndTargetIsOccupiedThenIsTrue() {
        Board board = this.boardBuilder.rows(" 0123456",
                "5       ",
                "4       ",
                "3       ",
                "2   RY  ",
                "1  RYY  ",
                "0 RYYR  ").build();
        board.dropToken(4, Color.RED);
        assertThat(board.isWinner(), is(true));
    }

    @Test
    public void testGivenBoardWhensMovsesXTokenOriginIsEmptyAndTargetIsOccupiedThenIsTrue() {
        Board board = this.boardBuilder.rows(" 0123456",
                "5       ",
                "4       ",
                "3    R  ",
                "2   RY  ",
                "1  RYY  ",
                "0  YYR  ").build();
        board.dropToken(1, Color.RED);
        assertThat(board.isWinner(), is(true));
    }

    @Test
    public void testGivenBoardWhdensMovsesXTokenOriginIsEmptyAndTargetIsOccupiedThenIsTrue() {
        Board board = this.boardBuilder.rows(" 0123456",
                "5       ",
                "4       ",
                "3    R  ",
                "2   RY  ",
                "1  RYY  ",
                "0  YYR  ").build();
        board.dropToken(Board.COLUMNS - 1, Color.RED);
        assertThat(board.isWinner(), is(false));
    }

}
