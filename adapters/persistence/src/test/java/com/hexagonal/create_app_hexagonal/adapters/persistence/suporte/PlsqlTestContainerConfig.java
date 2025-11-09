package com.hexagonal.create_app_hexagonal.adapters.persistence.suporte;


import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.utility.DockerImageName;

public abstract class PlsqlTestContainerConfig {

    private static final DockerImageName ORACLE_IMAGE =
            DockerImageName.parse("gvenzl/oracle-free:23-slim")
                    .asCompatibleSubstituteFor("gvenzl/oracle-xe");

    static final OracleContainer ORACLE_CONTAINER =
            new OracleContainer(ORACLE_IMAGE)
                    .withDatabaseName(ContainerEnum.DATA_BASE.getProperty())
                    .withUsername(ContainerEnum.USER_NAME.getProperty())
                    .withPassword(ContainerEnum.PASSWORD.getProperty())
                    .withInitScript("Plsql_DB.sql");

    static {
        ORACLE_CONTAINER.start();
    }

    @DynamicPropertySource
    static void register(DynamicPropertyRegistry registry) {
        registry.add(SpringDatasource.URL.getProperty(), ORACLE_CONTAINER::getJdbcUrl);
        registry.add(SpringDatasource.USER_NAME.getProperty(), ORACLE_CONTAINER::getUsername);
        registry.add(SpringDatasource.PASSWORD.getProperty(), ORACLE_CONTAINER::getPassword);
        registry.add("spring.flyway.enabled", () -> "false");
    }
}