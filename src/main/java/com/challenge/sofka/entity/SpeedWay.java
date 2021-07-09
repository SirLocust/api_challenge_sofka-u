package com.challenge.sofka.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SPEEDWAY")
@Data
@NoArgsConstructor
public class Speedway {
  @Id
  @Column(name = "ID_SPEEDWAY")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer distance;

  private Integer howManylanes;

}
