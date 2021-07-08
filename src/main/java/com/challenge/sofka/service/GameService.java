package com.challenge.sofka.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.challenge.sofka.entity.Driver;
import com.challenge.sofka.entity.Race;
import com.challenge.sofka.model.Dice;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@Data
// @NoArgsConstructor
public class GameService {

  private List<List<Integer>> turn = new ArrayList<>();
  private final Dice dice;
  private final RaceService raceService;

  public void setUpGame() {

  }

  public void initGame() {
    for (int i = 0; i < this.raceService.getRace().getDrivers().size(); i++) {
      this.turn.add(new ArrayList<Integer>(1));
      this.turn.get(i).add(0);
    }
    run();
  }

  private void run() {
    boolean isfinnish = false;
    while (!isfinnish) {
      isfinnish = stepToStep(this.raceService.getRace().getDrivers());
    }
    System.out.println(Arrays.toString(this.turn.toArray()));

  }

  private boolean stepToStep(List<Driver> drivers) {
    int numbersDrivers = drivers.size();

    for (int i = 0; i < numbersDrivers; i++) {
      if (this.isWinner(this.totalMove(this.turn.get(i)))) {
        System.out.println("gano uno ");
        return true;
      }
      this.turn.get(i).add(move());
    }

    return false;

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

  private boolean isWinner(Integer totalMove) {
    if (totalMove >= this.raceService.getRace().getSpeedway().getDistance()) {
      return true;
    }
    return false;
  }

}
