package com.challenge.sofka.model;

import org.springframework.stereotype.Component;

@Component
public class Dice {

  public int throwNumber() {
    return (int) Math.round((Math.random() * 5) + 1);
  }
}
