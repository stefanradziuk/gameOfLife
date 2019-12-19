package com.company;

public class Main {

  public static void main(String[] args) {

    Board blinker = new Board(10, 10, false);
    blinker.setPoint(3, 3, State.ALIVE);
    blinker.setPoint(4, 3, State.ALIVE);
    blinker.setPoint(5, 3, State.ALIVE);

    Board glider = new Board(10, 10, true);
    glider.setPoint(1, 0, State.ALIVE);
    glider.setPoint(2, 1, State.ALIVE);
    glider.setPoint(0, 2, State.ALIVE);
    glider.setPoint(1, 2, State.ALIVE);
    glider.setPoint(2, 2, State.ALIVE);

    Board pentadecathlon = new Board(20, 20, false);
    pentadecathlon.setPoint(8, 7, State.ALIVE);
    pentadecathlon.setPoint(10, 7, State.ALIVE);
    pentadecathlon.setPoint(8, 12, State.ALIVE);
    pentadecathlon.setPoint(10, 12, State.ALIVE);
    pentadecathlon.setPoint(9, 5, State.ALIVE);
    pentadecathlon.setPoint(9, 6, State.ALIVE);
    pentadecathlon.setPoint(9, 8, State.ALIVE);
    pentadecathlon.setPoint(9, 9, State.ALIVE);
    pentadecathlon.setPoint(9, 10, State.ALIVE);
    pentadecathlon.setPoint(9, 11, State.ALIVE);
    pentadecathlon.setPoint(9, 13, State.ALIVE);
    pentadecathlon.setPoint(9, 14, State.ALIVE);

    glider.evolve(1000, 200);

  }
}
