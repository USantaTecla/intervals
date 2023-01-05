package usantatecla.connect4.models;

public class RandomMachinePlayer extends MachinePlayer {

    RandomMachinePlayer(Color color, Board board) {
        super(color, board);
    }
    
    protected int calculateColumn() {
        int column;
        do {
            column = this.getRandomColumn();
        } while (this.isComplete(column));
        return column;
    }

    protected int getRandomColumn() {
        return (int) Math.floor(Math.random() * Board.COLUMNS);
    }

}