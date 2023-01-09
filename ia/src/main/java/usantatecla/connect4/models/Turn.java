package usantatecla.connect4.models;

import usantatecla.utils.BoundedIntDialog;
import usantatecla.utils.Console;

public class Turn {

    static final int NUMBER_PLAYERS = 2;
    private Player[] players;
    private int activePlayer;
    private Board board;
    private static final String NUM_USER_PLAYERS = "Número de jugadores humanos: ";
    private static final String PLAYER_WIN = "#color's WIN!!! : -)";
    private static final String PLAYERS_TIED = "TIED!!!";

    Turn(Board board) {
        this.board = board;
        this.players = new Player[Turn.NUMBER_PLAYERS];
    }

    void reset() {
        BoundedIntDialog boundedIntDialog = new BoundedIntDialog(0, Turn.NUMBER_PLAYERS);
        int userPlayers = boundedIntDialog.read(Turn.NUM_USER_PLAYERS);
        for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
            this.players[i] = i < userPlayers ? 
                new RandomPlayer(Color.get(i), this.board) : 
                new MinMaxPlayer(Color.get(i), this.board);
        }
        this.activePlayer = 0;
    }

    void dropToken(){
        this.getActivePlayer().dropToken();
        if (!this.board.isFinished()) {
            this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
        }
    }

    void writeResult() {
        String message = Turn.PLAYERS_TIED;
        if (this.board.isWinner()) {
            message = Turn.PLAYER_WIN
                .replace("#color", this.getActivePlayer().getColor().toString());  
        }
        Console.getInstance().writeln(message);
        this.board.writeResult();
    }

    Player getActivePlayer(){
        return this.players[this.activePlayer];
    }
    
}