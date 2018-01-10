package com.br.mercorp.heimdall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.br.mercorp.*")
@ComponentScan(basePackages = { "com.br.mercorp.*" })
@EntityScan("com.br.mercorp.*") 
public class HeimdallApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeimdallApplication.class, args);
	}
}
