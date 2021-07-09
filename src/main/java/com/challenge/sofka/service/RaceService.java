package com.challenge.sofka.service;

import java.util.Optional;

import com.challenge.sofka.entity.Race;

import com.challenge.sofka.repository.RaceRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RaceService {

  private final RaceRepository raceRepository;

  public Race getById(Long id) {
    Optional<Race> raceDb = this.raceRepository.findById(id);
    return raceDb.orElse(null);
  }

  public Race setRace(Race race) {
    return this.raceRepository.save(race);
  }

}