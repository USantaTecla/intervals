package usantatecla.connect4.models;

import usantatecla.utils.Console;

public abstract class Player {
    
    protected Color color;
    protected Board board;
    private static final String TURN = "Turn: ";

    Player(Color color, Board board) {
        this.color = color;
        this.board = board;        
    }

    void dropToken(){
        this.writePlayer();
        int column = this.getColumn();
        this.board.dropToken(column, this.color);
    }

    protected void writePlayer() {
        Console.getInstance().writeln(Player.TURN + this.getColor());
    }

    protected abstract int getColumn();

    public boolean isComplete(int column){
        return this.board.isComplete(column);
    }

    public Color getColor(){
        return this.color;
    }

}