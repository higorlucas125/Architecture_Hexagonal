package com.hexagonal.create_app_hexagonal.startapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.hexagonal.create_app_hexagonal")
@EntityScan(basePackages = "com.hexagonal.create_app_hexagonal.adapters.persistence.in.entity")
@EnableJpaRepositories(basePackages = "com.hexagonal.create_app_hexagonal.adapters.persistence.in.mysql.repository")
public class StartApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

}
