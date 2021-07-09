package com.challenge.sofka.service;

import java.util.ArrayList;
import java.util.List;

import com.challenge.sofka.entity.Driver;
import com.challenge.sofka.entity.Race;
import com.challenge.sofka.entity.Speedway;

import org.springframework.stereotype.Service;

@Service
public class RaceService {

  public Race getRace() {
    Race race = new Race();
    List<Driver> drivers = new ArrayList<>();
    Speedway speedway = new Speedway();
    speedway.setDistance(4000);
    speedway.setHowManylanes(4);

    drivers.add(new Driver(234L, "driver1", null));
    drivers.add(new Driver(2335L, "driver2", null));
    drivers.add(new Driver(231L, "driver3", null));
    drivers.add(new Driver(235L, "driver4", null));
    race.setDrivers(drivers);
    race.setSpeedway(speedway);

    return race

    ;
  }
}