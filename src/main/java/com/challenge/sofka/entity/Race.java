package com.challenge.sofka.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "RACES")
@Data
public class Race {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_RACE")
  private Long id;

  @OneToOne(cascade = { CascadeType.ALL })
  @JoinColumn(name = "ID_SPEEDWAY")
  private Speedway speedway;

  @OneToMany(cascade = { CascadeType.ALL })
  @JoinColumn(name = "ID_DRIVER")
  private List<Driver> drivers;

}
