package com.Attornatus.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.Attornatus.desafio.entities"})
public class CrudH2Application {

	public static void main(String[] args) {
		SpringApplication.run(CrudH2Application.class, args);
	}

}
