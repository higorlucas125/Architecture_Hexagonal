package com.hexagonal.create_app_hexagonal.adapters.persistence.suporte;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

public abstract class PostgresTestContainerConfig {
    protected static final PostgreSQLContainer<?> POSTGRE_SQL_CONTAINER =
            new PostgreSQLContainer<>("postgres:16.2")
                    .withDatabaseName(ContainerEnum.DATA_BASE.getProperty())
                    .withUsername(ContainerEnum.USER_NAME.getProperty())
                    .withPassword(ContainerEnum.PASSWORD.getProperty())
                    .withInitScript("Postgres_DB.sql");

    static {
        POSTGRE_SQL_CONTAINER.start();
    }


    @DynamicPropertySource
    static void register(DynamicPropertyRegistry registry){
        registry.add(SpringDatasource.URL.getProperty(), POSTGRE_SQL_CONTAINER::getJdbcUrl);
        registry.add(SpringDatasource.USER_NAME.getProperty(),POSTGRE_SQL_CONTAINER::getUsername);
        registry.add(SpringDatasource.PASSWORD.getProperty(),POSTGRE_SQL_CONTAINER::getPassword);
        registry.add("spring.flyway.enabled", () -> "false");
    }
}
