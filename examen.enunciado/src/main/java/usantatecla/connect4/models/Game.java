package usantatecla.connect4.models;

import usantatecla.utils.Console;
import usantatecla.utils.YesNoDialog;

public class Game {

    private Board board;
    private Turn turn;
    private static final String TITLE = "--- CONECTA 4 ---";
    private static final String RESUME = "Do you want to continue";

    public static void main(String[] args) {
        new Game().playGames();
    }

    private Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
        this.reset();
    }

    private void reset() {
        this.board.reset();
        this.turn.reset();
    }

    private void playGames() {
        do {
            this.playGame();
        } while (this.isResumed());
    }

    private void playGame() {
        Console.getInstance().writeln(Game.TITLE);
        this.board.writeln();
        do {
            this.turn.dropToken();
            this.board.writeln();
        } while (!this.board.isFinished());
        this.turn.writeResult();
    }

    private boolean isResumed() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Game.RESUME);
        if (yesNoDialog.isAffirmative()) {
            this.reset();
        }
        return yesNoDialog.isAffirmative();
    }

}