package com.company;

public class Board {

  private State[][] board;

  public Board(int rows, int cols) {
    board = new State[rows][cols];
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
        System.out.print(board[i][j].toString());
      }
      System.out.print('\n');
    }
  }
}
