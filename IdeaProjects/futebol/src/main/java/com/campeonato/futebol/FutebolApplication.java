package com.campeonato.futebol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;


@EntityScan("com.campeonato.futebol.Model")
@ComponentScan({
		"com.campeonato.futebol.ControllersAPI", "com.campeonato.futebol.Services"
})
@EnableJpaRepositories("com.campeonato.futebol.Repositorios")
@SpringBootApplication
public class FutebolApplication {
	public static void main(String[] args) {
		SpringApplication.run(FutebolApplication.class, args);
	}
}
