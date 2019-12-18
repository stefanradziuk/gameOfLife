package com.company;

public enum State {
  DEAD {
    @Override
    public String toString() {
      return "x";
    }
  },
  ALIVE {
    @Override
    public String toString() {
      return "o";
    }
  }
}
