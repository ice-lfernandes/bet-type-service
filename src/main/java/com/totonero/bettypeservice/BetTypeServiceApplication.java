package com.totonero.bettypeservice;

import java.util.TimeZone;
import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BetTypeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetTypeServiceApplication.class, args);
	}

	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
	}

}
