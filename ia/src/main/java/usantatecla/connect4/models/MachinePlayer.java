package usantatecla.connect4.models;

import usantatecla.utils.Console;

public abstract class MachinePlayer extends Player {

    private static final String COLUMN_TO_DROP = "Column to drop a token: ";
    
    MachinePlayer(Color color, Board board) {
        super(color, board);
    }

    @Override
    protected int getColumn(){
        int column = this.calculateColumn();
        this.writeColumn(column);
        return column;
    }

    protected abstract int calculateColumn();
    
    protected void writeColumn(int column) {
        Console.getInstance().writeln(MachinePlayer.COLUMN_TO_DROP + (column+1));
    }

}