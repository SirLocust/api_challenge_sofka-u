package com.challenge.sofka.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARS")
public class Car {

  @Id
  @Column(name = "ID_CAR")
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;

}
