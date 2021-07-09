package com.challenge.sofka.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.challenge.sofka.entity.Driver;
import com.challenge.sofka.entity.Race;
import com.challenge.sofka.model.Dice;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service

@Data
@AllArgsConstructor
public class GameService {

  private List<List<Integer>> turn = new ArrayList<>();
  private List<Integer> pos = new ArrayList();
  private final Dice dice;
  @Autowired
  private Race race;

  public void setUpGame(Race race) {
    this.race = race;
  }

  public Race initGame() {
    this.race.setStatus("PLAY");
    for (int i = 0; i < this.race.getDrivers().size(); i++) {

      this.turn.add(new ArrayList<>());
    }
    return run();
  }

  private Race run() {
    while (this.race.getStatus().equals("PLAY")) {
      stepToStep(this.race.getDrivers());
      if (this.race.getStatus().equals("FINISH")) {
        break;
      }
    }
    // System.out.println(Arrays.toString(this.turn.toArray()));
    this.resultsRace();
    this.race.setTurns(this.turn);
    return this.race;
  }

  private void stepToStep(List<Driver> drivers) {
    int numbersDrivers = drivers.size();
    for (int i = 0; i < numbersDrivers; i++) {
      this.turn.get(i).add(move());
      if (this.isWinner(this.totalMove(this.turn.get(i)))) {
        this.race.setStatus("FINISH");
        break;
      }
      System.out.println(this.totalMove(this.turn.get(i)) + "--" + i);

    }

    System.out.println("___________________");
  }

  private Integer move() {
    return dice.throwNumber() * 100;

  }

  private Integer totalMove(List<Integer> moves) {
    int result = 0;
    for (Integer move : moves) {
      result += move;
    }
    return result;
  }

  private boolean isWinner(int totalMove) {
    if (totalMove >= this.race.getSpeedway().getDistance()) {
      return true;
    }
    return false;
  }

  private void resultsRace() {
    HashMap<String, Integer> results = new HashMap<>();
    for (int i = 0; i < this.race.getDrivers().size(); i++) {
      results.put(this.race.getDrivers().get(i).getName(), totalMove(this.turn.get(i)));
    }
    List<Map.Entry<String, Integer>> reversedResults = new ArrayList<>();
    results.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach((p) -> {
      reversedResults.add(p);
      System.out.println(p);
    });

    // for (String key : results.keySet()) {
    // reversedResults.add(key + " : " + results.get(key).toString());
    // }

    this.race.setPodium(reversedResults);

  }

}