package com.somapay.challenge;

import com.somapay.challenge.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"com.somapay.challenge.controllers"})
@EntityScan("com.somapay.challenge.entities")
@EnableJpaRepositories("com.somapay.challenge.repositories")
public class ChallengeApplication {
	@Autowired
	private CompanyRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}

}
