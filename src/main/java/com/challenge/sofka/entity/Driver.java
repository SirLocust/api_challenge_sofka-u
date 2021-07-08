package com.challenge.sofka.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "DRIVERS")
@Data
public class Driver {

  @Id
  @Column(name = "ID_DRIVERS")
  private Long id;
  private String name;
  private Car car;

}
