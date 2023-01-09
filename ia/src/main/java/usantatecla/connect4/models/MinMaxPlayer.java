package usantatecla.connect4.models;

import java.util.List;

public class MinMaxPlayer extends RandomPlayer {

  private static final int MAX_STEPS = 4;

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
      int min = getMinCost(0);
      this.board.removeTop(column);
      if (min > maxMin) {
        maxMin = min;
        bestColumn = column;
      }
    }
    return bestColumn;
  }

  private int getMinCost(int steps) {
    if (this.isEnd(steps)) {
      return this.getCost();
    }
    int minCost = Integer.MAX_VALUE;
    for (Integer column : this.board.getValidColumns()) {
      this.board.dropToken(column, color.getOpposite());
      int cost = getMaxCost(steps + 1);
      this.board.removeTop(column);
      if (cost < minCost)
        minCost = cost;
    }
    return minCost;
  }

  private boolean isEnd(int steps) {
    return steps == MinMaxPlayer.MAX_STEPS || this.board.isFinished();
  }

  private int getCost() {
    // if (this.board.isFinished()) {
      if (this.board.isWinner(this.color)) {
        return Integer.MAX_VALUE;
      }
      if (this.board.isWinner(this.color.getOpposite())) {
        return Integer.MIN_VALUE;
      }
      return 0;
    // }
    // return this.board.cost(this.color) - this.board.cost(this.color.getOpposite());
  }

  private int getMaxCost(int steps) {
    if (this.isEnd(steps)) {
      return this.getCost();
    }
    int maxCost = Integer.MIN_VALUE;
    for (Integer column : this.board.getValidColumns()) {
      this.board.dropToken(column, color);
      int cost = getMinCost(steps + 1);
      this.board.removeTop(column);
      if (cost > maxCost)
        maxCost = cost;
    }
    return maxCost;
  }

}
