package com.challenge.sofka.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GAMES")
public class Game {

  @Id
  @Column(name = "ID_GAMES")
  private Long id;
  @OneToOne(cascade = { CascadeType.ALL })
  @JoinColumn(name = "ID_RACE")
  private Race race;
}
