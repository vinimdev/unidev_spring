package com.example.unidev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UnidevApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnidevApplication.class, args);
	}

}
