package com.hexagonal.create_app_hexagonal.adapters.persistence.suporte.testContainerConfig;

import com.hexagonal.create_app_hexagonal.adapters.persistence.PersistenceTestConfig;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

@ExtendWith(TestContainerExtension.class)
@SpringBootTest(classes = PersistenceTestConfig.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class MultiDatabaseTest {

    @DynamicPropertySource
    static void registerDynamicProperties(DynamicPropertyRegistry registry) {
        setupDatabaseProperties(registry, DatabaseType.MYSQL);
    }

    protected static void setupDatabaseProperties(DynamicPropertyRegistry registry, DatabaseType databaseType) {

        TestContainerExtension extension = new TestContainerExtension();
        extension.startContainer(databaseType);

        var config = TestContainerExtension.getDatasourceConfiguration();

        registry.add("spring.datasource.url", config::getUrl);
        registry.add("spring.datasource.username", config::getUser);
        registry.add("spring.datasource.password", config::getPass);

        registry.add("spring.flyway.enabled", () -> "false");
    }
}
