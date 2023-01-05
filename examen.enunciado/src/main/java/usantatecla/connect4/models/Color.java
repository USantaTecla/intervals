package usantatecla.connect4.models;

public enum Color {

    RED,
    YELLOW,
    NULL;

    private static final Color[] PLAYERS = {Color.RED, Color.YELLOW};

    public static Color get(int ordinal) {
        assert ordinal >= 0 && ordinal < Color.NULL.ordinal();

        return Color.values()[ordinal];
    }

    public boolean isNull() {
        return this == Color.NULL;
    }

    public Color getOpposite() {
        assert this != Color.NULL;

        return Color.values()[(this.ordinal() + 1) % Color.PLAYERS.length];
    }

    public char getCode() {
        if (this == Color.NULL){
            return ' ';
        }
        return this.toString().charAt(0);
    }

    @Override
    public String toString() {
        return this.name();
    }

}
