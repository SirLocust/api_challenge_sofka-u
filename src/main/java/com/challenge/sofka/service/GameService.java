package com.challenge.sofka.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.challenge.sofka.entity.Driver;
import com.challenge.sofka.entity.Race;
import com.challenge.sofka.model.Dice;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service

@Data
@AllArgsConstructor
public class GameService {

  private List<List<Integer>> turn = null;
  private final Dice dice;
  private Race race;

  public void setUpGame(Race race) {
    this.race = race;
    this.turn = new ArrayList<>();
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
    }
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
    Map<String, Integer> results = new HashMap<>();
    for (int i = 0; i < this.race.getDrivers().size(); i++) {
      results.put(this.race.getDrivers().get(i).getName(), totalMove(this.turn.get(i)));
    }
    List<String> reversedResults = new ArrayList<>();
    results.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach((p) -> {
      reversedResults.add(p.toString());
    });
    this.race.setPodium(reversedResults);
  }

}