package com.company;

public class Main {

  public static void main(String[] args) {

    Board board1 = new Board(10, 10);
    board1.setPoint(3, 3, State.ALIVE);
    board1.setPoint(4, 3, State.ALIVE);
    board1.setPoint(5, 3, State.ALIVE);

//    System.out.println(board1.neighbours(4, 2));
//    System.out.println(board1.neighbours(4, 3));
//    System.out.println(board1.neighbours(4, 4));

    try {
      board1.printBoard();
      Thread.sleep(1000);
      System.out.print("\033[H\033[2J");
      System.out.flush();
      board1.nextGen().printBoard();
      Thread.sleep(1000);
      System.out.print("\033[H\033[2J");
      System.out.flush();
      board1.nextGen().nextGen().printBoard();
      Thread.sleep(1000);
      System.out.print("\033[H\033[2J");
      System.out.flush();
      board1.nextGen().nextGen().nextGen().printBoard();
      Thread.sleep(1000);
      System.out.print("\033[H\033[2J");
      System.out.flush();
      board1.nextGen().nextGen().nextGen().nextGen().printBoard();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}
