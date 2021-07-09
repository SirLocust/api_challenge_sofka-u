package com.challenge.sofka.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "DRIVERS")
@Data
@AllArgsConstructor
public class Driver {

  @Id
  @Column(name = "ID_DRIVER")
  private Long id;
  private String name;

  @OneToOne(cascade = { CascadeType.ALL })
  @JoinColumn(name = "ID_CAR")
  private Car car;

}
