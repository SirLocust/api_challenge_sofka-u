package com.challenge.sofka.controller;

import com.challenge.sofka.entity.Race;
import com.challenge.sofka.service.GameService;
import com.challenge.sofka.service.RaceService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/game")
public class GameController {

  private final GameService gameService;
  private final RaceService raceService;

  @GetMapping
  public ResponseEntity<Race> startGame() {

    this.gameService.setRace(this.raceService.getRace());
    Race race = this.gameService.initGame();
    return ResponseEntity.ok(race);
  }
}
