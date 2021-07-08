package com.challenge.sofka.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GAMES")
public class Game {

  @Id
  @Column(name = "ID_GAMES")
  private Race race;
}
