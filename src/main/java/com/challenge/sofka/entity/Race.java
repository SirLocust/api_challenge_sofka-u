package com.challenge.sofka.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "RACES")
@Data
public class Race {

  @Id

  @Column(name = "ID_RACES")
  private Long id;

  private SpeedWay speedWay;

  @OneToMany(cascade = { CascadeType.ALL })
  @JoinColumn(name = "ID_DRIVERS")
  private List<Driver> drivers;

}
