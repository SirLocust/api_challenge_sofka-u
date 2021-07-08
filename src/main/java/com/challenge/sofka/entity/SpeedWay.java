package com.challenge.sofka.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "SPEEDWAYS")
@Data
public class SpeedWay {

  @Id
  @Column(name = "ID_SPEEDWAYS")
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;
  private int distance;
  private int howManylanes;

}