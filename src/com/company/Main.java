package com.company;

public class Main {

  public static void main(String[] args) {
    Board board1 = new Board(10, 10);
    board1.setPoint(3, 3, State.ALIVE);
    board1.setPoint(4, 3, State.ALIVE);
    board1.setPoint(5, 3, State.ALIVE);

    System.out.println(board1.neighbours(4, 2));

    board1.printBoard();
    System.out.println("------------");
    board1.nextGen().printBoard();
    System.out.println("------------");
    board1.nextGen().nextGen().printBoard();
    System.out.println("------------");
    board1.nextGen().nextGen().nextGen().printBoard();
    System.out.println("------------");
    board1.nextGen().nextGen().nextGen().nextGen().printBoard();

  }
}
