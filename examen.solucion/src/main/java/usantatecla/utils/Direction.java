package usantatecla.utils;

public enum Direction {

	NORTH(1, 0),
	NORTH_EAST(1, 1),
	EAST(0, 1),
	SOUTH_EAST(-1, 1),
	SOUTH(-1, 0),
	SOUTH_WEST(-1, -1),
	WEST(0, -1),
	NORTH_WEST(1, -1),
	NULL();

	private final ClosedInterval LIMITS = new ClosedInterval(-1, 1);
	private Coordinate coordinate;

	private Direction() {
	}

	private Direction(int row, int column) {
		assert this.LIMITS.isIncluded(row) && this.LIMITS.isIncluded(column);

		this.coordinate = new Coordinate(row, column);
	}

	public Direction next() {
		assert this.isNull();
		assert this != Direction.NORTH_WEST;

		if (this == Direction.NORTH_WEST) {
			return Direction.NORTH;
		}
		return Direction.values()[this.ordinal() + 1];
	}

	public Coordinate next(Coordinate coordinate) {
		assert this != Direction.NULL;

		return new Coordinate(
			this.coordinate.getRow() + coordinate.getRow(),
			this.coordinate.getColumn() + coordinate.getColumn());
	}

	public Direction getOpposite() {
		assert this.isNull();

		final int LENGTH = Direction.values().length - 1;
		return Direction.values()[(this.ordinal() + LENGTH / 2) % LENGTH];
	}

	private boolean isNull() {
		return this == Direction.NULL;
	}

}
