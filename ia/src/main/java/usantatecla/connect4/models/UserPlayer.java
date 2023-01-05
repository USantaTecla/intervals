package usantatecla.connect4.models;

import usantatecla.utils.Console;

public class UserPlayer extends Player {
    
    private static final String COLUMN_TO_DROP = "Enter a column to drop a token? ";
    private static final String INVALID_COLUMN = "Invalid columnn!!! Values [1-7]";
    private static final String COMPLETED_COLUMN = "Invalid column!!! It's completed";

    UserPlayer(Color color, Board board) {
        super(color, board);
    }

    @Override
    protected int getColumn(){
        int column;
        boolean valid;
        do {
            column = Console.getInstance().readInt(UserPlayer.COLUMN_TO_DROP) - 1;
            valid = Board.isColumnValid(column);
            if (!valid) {
                Console.getInstance().write(UserPlayer.INVALID_COLUMN);
            } else {
                valid = !this.isComplete(column);
                if (!valid) {
                    Console.getInstance().writeln(UserPlayer.COMPLETED_COLUMN);
                }
            }
        } while (!valid);
        return column;
    }

}
