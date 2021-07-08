package com.challenge.sofka.repository;

import com.challenge.sofka.entity.Game;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
