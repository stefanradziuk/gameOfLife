package com.company;

public class Board {

  private State[][] board;
  private int rows;
  private int cols;
  private boolean isInfinite;

  public Board(int rows, int cols, boolean isInfinite) {
    board = new State[rows][cols];
    this.isInfinite = isInfinite;
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

  private int modulus(int a, int b) {
    if (a < 0) {
      return a % b + b;
    }
    return a % b;
  }

  public int neighbours(int row, int col) {
    int result = 0;
    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {
        int nRow = row + i;
        int nCol = col + j;
        if (isInfinite) {
          nRow = modulus(nRow, rows);
          nCol = modulus(nCol, cols);
        }
        if (!(i == 0 && j == 0) &&
            nRow >= 0 && nRow < rows &&
            nCol >= 0 && nCol < cols &&
            getPoint(nRow, nCol).equals(State.ALIVE)) {
          result += 1;
        }
      }
    }
    return result;
  }

  public Board nextGen() {
    Board nextGen = new Board(rows, cols, isInfinite);
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

  public void evolve(int n, long delay) {
    System.out.print("\n");
    System.out.print("\033[H\033[2J");
    System.out.flush();
    printBoard();

    if (n > 0) {
      try {
        Thread.sleep(delay);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      nextGen().evolve(n - 1, delay);
    }
  }
}