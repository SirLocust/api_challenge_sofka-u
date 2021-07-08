package com.challenge.sofka.model;

public class Dice {

  public int throwNumber() {
    return (int) Math.round((Math.random() * 5) + 1);
  }
}
