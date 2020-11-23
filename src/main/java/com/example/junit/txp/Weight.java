package com.example.junit.txp;

public enum Weight {
  MustMatch(5),
  VeryVeryImportant(4),
  VeryImportant(3),
  Important(2),
  WouldPrefer(1),
  DontCare(0);

  private int value;

  Weight(int value) {this.value = value;}
  public int getValue() {
    return value;
  }
}
