package com.hexagonal.create_app_hexagonal.adapters.persistence.suporte;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;

public abstract class MysqlTestContainerConfig {
    static final MySQLContainer<?> MY_SQL_CONTAINER =
            new MySQLContainer<>("mysql:8.0")
                    .withDatabaseName(ContainerEnum.DATA_BASE.getProperty())
                    .withUsername(ContainerEnum.USER_NAME.getProperty())
                    .withPassword(ContainerEnum.PASSWORD.getProperty())
                    .withUrlParam("useSSL", "false")
                    .withUrlParam("allowPublicKeyRetrieval", "true")
                    .withInitScript("Create_DB.sql");

    static {
        MY_SQL_CONTAINER.start();
    }

    @DynamicPropertySource
    static void register(DynamicPropertyRegistry registry){
        registry.add(SpringDatasource.URL.getProperty(), MY_SQL_CONTAINER::getJdbcUrl);
        registry.add(SpringDatasource.USER_NAME.getProperty(), MY_SQL_CONTAINER::getUsername);
        registry.add(SpringDatasource.PASSWORD.getProperty(), MY_SQL_CONTAINER::getPassword);
        registry.add("spring.flyway.enabled", () -> "false");
    }
}
