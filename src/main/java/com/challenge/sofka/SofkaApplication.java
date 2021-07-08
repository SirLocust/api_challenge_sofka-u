package com.challenge.sofka;

import com.challenge.sofka.model.Dice;
import com.challenge.sofka.service.GameService;
import com.challenge.sofka.service.RaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.challenge.sofka.entity")
public class SofkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SofkaApplication.class, args);

	}

}
