package usantatecla.utils;

public class Coordinate {

	private int row;
	private int column;

	public Coordinate() {
	}

	public Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public Coordinate copy() {
		return new Coordinate(this.row, this.column);
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

	@Override
	public String toString() {
		return "Coordinate (" + row + ", " + column + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

}
