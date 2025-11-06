package com.hexagonal.create_app_hexagonal.adapters.persistence.suporte;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.hexagonal.create_app_hexagonal")
@EnableJpaRepositories(basePackages = "com.hexagonal.create_app_hexagonal.adapters.persistence.in.repository")
@EntityScan(basePackages = "com.hexagonal.create_app_hexagonal.adapters.persistence.in.entity")
public class PersistenceTestConfig {
}