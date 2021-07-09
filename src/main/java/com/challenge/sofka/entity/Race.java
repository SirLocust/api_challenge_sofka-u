package com.challenge.sofka.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionType;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
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

  @ManyToMany(cascade = { CascadeType.ALL })
  // @JoinColumn(name = "ID_DRIVER")
  @JoinTable(name = "RACE_DRIVER", joinColumns = @JoinColumn(name = "ID_RACE"), inverseJoinColumns = @JoinColumn(name = "ID_DRIVER"))
  // @ElementCollection(targetClass = ArrayList.class)
  private List<Driver> drivers;

  private String status;

  @Column(name = "TURNS")
  @ElementCollection(targetClass = ArrayList.class)
  private List<List<Integer>> turns;

  @ElementCollection(targetClass = ArrayList.class)

  private List<String> podium;

}
