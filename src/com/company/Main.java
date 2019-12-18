package com.company;

public class Main {

  public static void main(String[] args) {
    Board board1 = new Board(10, 10);
    board1.setPoint(3, 1, State.ALIVE);
    board1.setPoint(4, 1, State.ALIVE);
    board1.setPoint(6, 1, State.ALIVE);

    board1.printBoard();
  }
}
