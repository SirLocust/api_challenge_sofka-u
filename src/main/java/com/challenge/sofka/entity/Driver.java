package com.challenge.sofka.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DRIVERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

  @Id
  @Column(name = "ID_DRIVER")
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;
  private String name;

  @ManyToMany(cascade = { CascadeType.ALL })
  private List<Race> races;

  // @Column(nullable = )
  @OneToOne(cascade = { CascadeType.ALL })
  @JoinColumn(name = "ID_CAR")
  private Car car;

}
