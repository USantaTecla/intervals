package usantatecla.connect4.models;

import java.util.List;

public class MinMaxPlayer extends RandomMachinePlayer {

  private static final int MAX_STEPS = 5;

  MinMaxPlayer(Color color, Board board) {
    super(color, board);
  }

  @Override
  protected int calculateColumn() {
    List<Integer> validColumns = this.board.getValidColumns();
    int bestColumn = validColumns.get(0);
    int maxMin = Integer.MIN_VALUE;
    for (Integer column : validColumns) {
      this.board.dropToken(column, color);
      int min = getMinMin(0);
      this.board.removeTop(column);
      if (min > maxMin) {
        maxMin = min;
        bestColumn = column;
      }
    }
    return bestColumn;
  }

  private int getMinMin(int steps) {
    if (this.isEnd(steps)) {
      return this.getCost();
    }
    int minMin = Integer.MAX_VALUE;
    for (Integer column : this.board.getValidColumns()) {
      this.board.dropToken(column, color.getOpposite());
      int min = getMaxMin(steps + 1);
      this.board.removeTop(column);
      if (min < minMin)
        minMin = min;
    }
    return minMin;
  }

  private boolean isEnd(int steps) {
    return steps == MinMaxPlayer.MAX_STEPS || this.board.isFinished();
  }

  private int getCost() {
    if (this.board.isFinished()) {
      if (this.board.isWinner(this.color)) {
        return Integer.MAX_VALUE;
      }
      if (this.board.isWinner(this.color.getOpposite())) {
        return Integer.MIN_VALUE;
      }
      return 0;
    }
    return this.board.cost(this.color) - this.board.cost(this.color.getOpposite());
  }

  private int getMaxMin(int steps) {
    if (this.isEnd(steps)) {
      return this.getCost();
    }
    int maxMin = Integer.MIN_VALUE;
    for (Integer column : this.board.getValidColumns()) {
      this.board.dropToken(column, color);
      int min = getMinMin(steps + 1);
      this.board.removeTop(column);
      if (min > maxMin)
        maxMin = min;
    }
    return maxMin;
  }

}
