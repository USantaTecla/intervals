package usantatecla.connect4.models;

import java.util.ArrayList;
import java.util.List;

import usantatecla.utils.Coordinate;
import usantatecla.utils.Direction;

class LinePositioner {

    private Coordinate origin;
    static final int LENGTH = 4;
    private static final int MAX_DISPLACEMENT = LinePositioner.LENGTH - 1;
    private Direction direction;
    private int displacements;

    LinePositioner(Coordinate origin) {
        this.origin = origin;
        this.direction = Direction.NORTH_EAST;
        this.displacements = 0;
    }

    boolean hasNextPosition() {
        return this.direction.ordinal() < Direction.SOUTH.ordinal()
                || this.displacements < 1;
    }

    List<Coordinate> nextPosition() {
        assert this.hasNextPosition();

        List<Coordinate> coordinates = this.getCoordinates();
        this.displacements++;
        if (this.displacements > LinePositioner.MAX_DISPLACEMENT) {
            this.displacements = 0;
            this.direction = this.direction.next();
        }
        return coordinates;
    }

    private List<Coordinate> getCoordinates() {
        List<Coordinate> coordinates = getDirectionCoordinates();
        for (int i = 0; i < this.displacements; i++) {
            coordinates = this.getShiftedCoordinates(coordinates);
        }
        return coordinates;
    }

    private List<Coordinate> getDirectionCoordinates() {
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        coordinates.add(this.origin.copy());
        for (int i = 1; i < LinePositioner.LENGTH; i++) {
            coordinates.add(this.direction.next(coordinates.get(i - 1)));
        }
        return coordinates;
    }

    private List<Coordinate> getShiftedCoordinates(List<Coordinate> coordinates) {
        List<Coordinate> shiftedCoordinates = new ArrayList<Coordinate>();
        for (Coordinate coordinate : coordinates) {
            shiftedCoordinates.add(this.direction.getOpposite().next(coordinate));
        }
        return shiftedCoordinates;
    }

}