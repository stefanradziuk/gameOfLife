package com.company;

import java.util.Scanner;

public class BoardClient {

  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.print("\n");
    System.out.print("\033[H\033[2J");
    System.out.flush();
    System.out.println("\tWelcome to The Game of Life!");
    System.out.println("Enter the number of rows:");
    int rows = getAnInt();
    System.out.println("Enter the number of columns:");
    int cols = getAnInt();
    System.out.println("Should the board be infinite? [y/N]");
    String isInfiniteInput = input.nextLine();
    boolean isInfinite = isInfiniteInput.isEmpty() || isInfiniteInput.charAt(0) == 'y';
    Board clientBoard = new Board(rows, cols, isInfinite);
    System.out.println("Enter the number of iterations:");
    int iterations = getAnInt();
    System.out.println("Enter the delay (in ms):");
    int delay = getAnInt();
    System.out.println("How many alive points would you like to start with?");
    int pointNo = getAnInt();
    for (int i = 0; i < pointNo; i++) {
      System.out.println("Point " + (i + 1) + ": Enter the row coordinate:");
      int row = getAnInt();
      System.out.println("Point " + (i + 1) + ": Enter the column coordinate:");
      int col = getAnInt();
      clientBoard.setPoint(row, col, State.ALIVE);
    }
    clientBoard.evolve(iterations, delay);
  }

  private static int getAnInt() {
    try {
      return Integer.parseInt(input.nextLine());
    } catch (NumberFormatException e) {
      System.out.println("Wrong input format – try again:");
      return getAnInt();
    }
  }

}
