package com.challenge.sofka.controller;

import java.util.HashMap;
import java.util.Map;

import com.challenge.sofka.entity.Race;

import com.challenge.sofka.service.GameService;
import com.challenge.sofka.service.RaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping(value = "/game")
public class GameController {

  @Autowired
  private GameService gameService;
  @Autowired
  private RaceService raceService;

  @GetMapping("/{id}")
  public ResponseEntity<Race> startGame(@PathVariable("id") Long id) {

    Race raceDb = this.raceService.getById(id);
    if (raceDb == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    if (raceDb.getStatus().equals("FINISH")) {
      return ResponseEntity.ok(raceDb);
    }
    this.gameService.setUpGame(raceDb);
    Race race = this.gameService.initGame();
    this.raceService.setRace(race);
    return ResponseEntity.ok(raceDb);
  }

  @PostMapping
  public ResponseEntity<Map<String, Object>> createGame(@RequestBody Race race) {
    Map<String, Object> errors = this.checkRaceCorrect(race);
    if (errors != null) {
      return ResponseEntity.badRequest().body(errors);
    }
    race.setStatus("START");
    Race raceDb = this.raceService.setRace(race);
    Map<String, Object> body = new HashMap<>();
    body.put("Id", raceDb.getId().toString());
    body.put("Message", "Juego Iniciado");
    return ResponseEntity.status(HttpStatus.CREATED).body(body);
  }

  private Map<String, Object> checkRaceCorrect(Race race) {
    Map<String, Object> message = new HashMap<>();
    if (race.getSpeedway() == null || race.getSpeedway().getDistance() <= 0) {
      message.put("Error", "Es necesario enviar una pista y que la distancia de esta sea mayor a 0");
      return message;
    }
    if (race.getDrivers() == null || race.getDrivers().size() < 3) {
      message.put("Error", "Es necesario enviar los conductores y que sean Tres conductores o m??s ");
      return message;
    }
    if (race.getDrivers().size() != race.getSpeedway().getHowManylanes()) {
      message.put("Error", "El n??mero de carriles y el n??mero de conductores debe ser igual");
      return message;
    }
    return null;
  }
}
