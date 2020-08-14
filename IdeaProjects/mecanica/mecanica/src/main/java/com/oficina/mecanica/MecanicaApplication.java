package com.oficina.mecanica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.oficina.mecanica.model")
@EnableJpaRepositories("com.oficina.mecanica.repositories")
@ComponentScan({
		"com.oficina.mecanica.controllers", "com.oficina.mecanica.services"
})
@SpringBootApplication
public class MecanicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MecanicaApplication.class, args);
	}

}
