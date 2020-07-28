package com.sg.lanchessg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.sg.lanchessg.Model")
@ComponentScan("com.sg.lanchessg.Controllers")
@EnableJpaRepositories("com.sg.lanchessg.Repositories")
@SpringBootApplication
public class LanchessgApplication {

	public static void main(String[] args) {
		SpringApplication.run(LanchessgApplication.class, args);
	}

}
