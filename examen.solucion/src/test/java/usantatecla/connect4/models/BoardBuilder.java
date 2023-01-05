package usantatecla.connect4.models;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BoardBuilder {

    private List<String> rows;

    public BoardBuilder() {
        this.rows = new ArrayList<String>();
        this.rows(" 0123456",
                "5       ",
                "4       ",
                "3       ",
                "2       ",
                "1       ",
                "0       ");
    }

    public BoardBuilder rows(String... rows) {
        assertStrings(rows);
        this.rows = this.filterBorders(rows);
        return this;
    }

    private void assertStrings(String... rows) {
        assert rows.length == Board.ROWS + 1;
        assert rows[0].equals(" 0123456");
        for (int i = 1; i < rows.length; i++) {
            assert rows[i].length() == Board.COLUMNS + 1;
            assert rows[i].charAt(0) - '0' == Board.ROWS - i;
            assert Pattern.matches("[RY ]{" + Board.COLUMNS + "}", rows[i].substring(1));
            if (i < rows.length - 1) {
                for (int j = 1; j < Board.COLUMNS; j++) {
                    assert rows[i].charAt(j) == ' '
                            || rows[i].charAt(j) != ' ' && rows[i + 1].charAt(j) != ' ';
                }
            }
        }
    }

    private List<String> filterBorders(String... rows) {
        List<String> filteredRows = new ArrayList<String>();
        for (int i = 1; i < rows.length; i++) {
            filteredRows.add(rows[i].substring(1));
        }
        return filteredRows;
    }

    public Board build() {
        Board board = new Board();
        for (int i = this.rows.size() - 1; i >= 0; i--) {
            String string = this.rows.get(i);
            for (int j = 0; j < string.length(); j++) {
                Color color = this.getColor(string.charAt(j));
                if (!color.isNull()) {
                    board.dropToken(j, color);
                }
            }
        }
        return board;
    }

    private Color getColor(char character) {
        for (int i = 0; i < Color.values().length - 1; i++) {
            Color color = Color.values()[i];
            if (color.name().charAt(0) == character) {
                return color;
            }
        }
        return Color.NULL;
    }

}
