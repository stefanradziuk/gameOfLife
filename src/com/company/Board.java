package com.company;

public class Board {

  private State[][] board;
  private int rows;
  private int cols;

  public Board(int rows, int cols) {
    board = new State[rows][cols];
    this.rows = rows;
    this.cols = cols;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        board[i][j] = State.DEAD;
      }
    }
  }

  public void setPoint(int row, int col, State state) {
    board[row][col] = state;
  }

  public State getPoint(int row, int col) {
    return board[row][col];
  }

  public void printBoard() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(getPoint(i, j).toString());
      }
      System.out.print('\n');
    }
  }

  public int neighbours(int row, int col) {
    int result = 0;
    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {
        int nRow = row + i;
        int nCol = col + j;
        if (i * j != 0 &&
            nRow >= 0 && nRow < this.rows &&
            nCol >= 0 && nCol < this.cols) {
          switch (getPoint(nRow, nCol)) {
            case ALIVE:
              result += 1;
            case DEAD:
              break;
          }
        }
      }
    }
    return result;
  }

  public Board nextGen() {
    Board nextGen = new Board(rows, cols);
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int neighbours = this.neighbours(i, j);
        if (neighbours == 3) {
          nextGen.setPoint(i, j, State.ALIVE);
        } else if (neighbours == 2 && this.getPoint(i, j).equals(State.ALIVE)) {
          nextGen.setPoint(i, j, State.ALIVE);
        }
      }
    }
    return nextGen;
  }
}