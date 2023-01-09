package usantatecla.connect4.models;

public class TrickyRandomMachinePlayer extends RandomPlayer {

    TrickyRandomMachinePlayer(Color color, Board board) {
        super(color, board);
    }

    @Override
    protected int calculateColumn() {
        if (this.board.isEmpty()) {
            return super.calculateColumn();
        }
        int column;
        do {
            column = this.getRandomColumn();
        } while (!this.board.isTop(column, this.color.getOpposite()));
        this.moveRandomTopFrom(column);
        return column;
    }

    private void moveRandomTopFrom(int origin) {
        this.board.removeTop(origin);
        int column;
        do {
            column = this.getRandomColumn();
        } while (origin == column || this.isComplete(column));
        this.board.dropToken(column, this.color.getOpposite());
    }

}