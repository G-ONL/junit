package com.example.junit.txp;

public enum Level {
  EXPERT(5),
  PROFESSIONAL(4),
  ADVANCED(3),
  INTERMEDIATE(2),
  BEGINNER(1);

  private int value;

  Level(int value) {this.value = value;}
  public int getValue() {
    return value;
  }
}
