package usantatecla.connect4.models;

import java.util.ArrayList;
import java.util.List;

import usantatecla.utils.ClosedInterval;
import usantatecla.utils.Console;
import usantatecla.utils.Coordinate;
import usantatecla.utils.Direction;

class Board {

    public static final int ROWS = 6;
    public static final int COLUMNS = 7;
    private static final ClosedInterval INTERVAL_ROWS = new ClosedInterval(0, Board.ROWS - 1);
    private static final ClosedInterval INTERVAL_COLUMNS = new ClosedInterval(0, Board.COLUMNS - 1);
    private Color[][] colors;
    private Coordinate lastDrop;
    private static final String HORIZONTAL_LINE = "-";
    private static final String VERTICAL_LINE = "|";
    private static final String CONNETED_COORDINATES = "Connected coordinates:";

    public static boolean isColumnValid(int column) {
        return Board.INTERVAL_COLUMNS.isIncluded(column);
    }

    public boolean isValid(Coordinate coordinate) {
        return Board.INTERVAL_ROWS.isIncluded(coordinate.getRow())
                && Board.INTERVAL_COLUMNS.isIncluded(coordinate.getColumn());
    }

    Board() {
        this.colors = new Color[Board.ROWS][Board.COLUMNS];
        this.reset();
    }

    void reset() {
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                this.setColor(new Coordinate(i, j), Color.NULL);
            }
        }
    }

    private void setColor(Coordinate coordinate, Color color) {
        this.colors[coordinate.getRow()][coordinate.getColumn()] = color;
    }

    void dropToken(int column, Color color) {
        assert !this.isComplete(column);
        assert !color.isNull();

        this.lastDrop = new Coordinate(0, column);
        while (!this.isEmpty(this.lastDrop)) {
            this.lastDrop = Direction.NORTH.next(this.lastDrop);
        }
        this.setColor(lastDrop, color);
    }

    boolean isComplete(int column) {
        return !this.isEmpty(new Coordinate(Board.ROWS - 1, column));
    }

    boolean isComplete() {
        for (int i = 0; i < Board.COLUMNS; i++) {
            if (!this.isComplete(i)) {
                return false;
            }
        }
        return true;
    }

    void writeln() {
        this.writeHorizontal();
        String string = "";
        for (int i = Board.ROWS - 1; i >= 0; i--) {
            string += Board.VERTICAL_LINE;
            for (int j = 0; j < Board.COLUMNS; j++) {
                string += " " + this.getColor(new Coordinate(i, j)).getCode() + " ";
                string += Board.VERTICAL_LINE;
            }
            string += "\n";
        }
        Console.getInstance().write(string);
        this.writeHorizontal();
    }

    private void writeHorizontal() {
        String string = "";
        for (int i = 0; i < " x |".length() * Board.COLUMNS; i++) {
            string += Board.HORIZONTAL_LINE;
        }
        string += Board.HORIZONTAL_LINE;
        Console.getInstance().writeln(string);
    }

    boolean isFinished() {
        return this.isComplete() || this.isWinner();
    }

    boolean isWinner() {
        LinePositioner linePositioner = new LinePositioner(this.lastDrop);
        while (linePositioner.hasNextPosition()) {
            if (this.isWinner(linePositioner.nextPosition())) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinner(List<Coordinate> coordinates) {
        if (!this.isValid(coordinates.get(0))) {
            return false;
        }
        for (int i = 1; i < coordinates.size(); i++) {
            if (!this.isValid(coordinates.get(i))
                    || this.getColor(coordinates.get(i - 1)) != this.getColor(coordinates.get(i))) {
                return false;
            }
        }
        return true;
    }

    void writeResult() {
        if (this.isWinner()){
            LinePositioner linePositioner = new LinePositioner(this.lastDrop);
            List<Coordinate> coordinates = linePositioner.nextPosition();
            while (!this.isWinner(coordinates)) {
                coordinates = linePositioner.nextPosition();
            }
            String string = Board.CONNETED_COORDINATES;
            for (Coordinate coordinate : coordinates) {
                string += "\n" + Direction.EAST.next(Direction.NORTH.next(coordinate));
            }
            Console.getInstance().writeln(string);
        }
    }

    private boolean isOccupied(Coordinate coordinate, Color color) {
        return this.getColor(coordinate) == color;
    }

    private boolean isEmpty(Coordinate coordinate) {
        return this.isOccupied(coordinate, Color.NULL);
    }

    private Color getColor(Coordinate coordinate) {
        return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }

    boolean isTop(int column, Color color) {
        if (this.isEmpty(column)) {
            return false;
        }
        return this.getColor(this.getTop(column)) == color;
    }

    private Coordinate getTop(int column) {
        assert !this.isEmpty(column);

        Coordinate coordinate = new Coordinate(Board.ROWS - 1, column);
        while (this.isEmpty(coordinate)) {
            coordinate = Direction.SOUTH.next(coordinate);
        }
        return coordinate;
    }

    private boolean isEmpty(int column) {
        return this.isEmpty(new Coordinate(0, column));
    }

    void removeTop(int column) {
        assert !this.isEmpty(column);

        this.setColor(this.getTop(column), Color.NULL);
    }

    boolean isEmpty() {
        for (int i = 0; i < Board.COLUMNS; i++) {
            if (!this.isEmpty(i)) {
                return false;
            }
        }
        return true;
    }

    List<Integer> getValidColumns() {
        List<Integer> notCompleteColumns = new ArrayList<Integer>();
        for (int j = 0; j < Board.COLUMNS; j++) {
            if (!this.isComplete(j)) {
                notCompleteColumns.add(j);
            }
        }
        return notCompleteColumns;

    }

    // por qué vuelve a poner?!?!
    public int cost(Color color) {
        int cost = 0;
        for (Integer column : this.getValidColumns()) {
            this.dropToken(column, color);
            if (this.isWinner()) {
                cost++;
            }
            this.removeTop(column);
        }
        return cost;
    }

    public boolean isWinner(Color color) {
        return this.isWinner() && color == this.getColor(this.lastDrop);
    }

}