package com.company;

public enum State {
  DEAD {
    @Override
    public String toString() {
      return "." + " ";
    }
  },
  ALIVE {
    @Override
    public String toString() {
      return "\033[1m" + "o" + "\033[0m" + " ";
    }
  }
}
