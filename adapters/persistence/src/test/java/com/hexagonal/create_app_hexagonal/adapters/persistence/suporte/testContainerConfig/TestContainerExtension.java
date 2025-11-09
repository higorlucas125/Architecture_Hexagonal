package com.hexagonal.create_app_hexagonal.adapters.persistence.suporte.testContainerConfig;

import com.hexagonal.create_app_hexagonal.adapters.persistence.suporte.ContainerEnum;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

public class TestContainerExtension implements BeforeAllCallback, BeforeEachCallback {

    private static MySQLContainer<?> mySQLContainer;
    private static OracleContainer oracleContainer;
    private static PostgreSQLContainer<?> postgreSQLContainer;
    private static DatasourceConfiguration datasourceConfiguration;

    private static final ThreadLocal<DatasourceConfiguration> currentConfig = new ThreadLocal<>();

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {

        var classAnnotation = context.getRequiredTestClass().getAnnotation(
                com.hexagonal.create_app_hexagonal.adapters.persistence.suporte.testContainerConfig.TestSql.class);

        if (classAnnotation != null) {
            startContainer(classAnnotation.value());
        }

    }


    @Override
    public void beforeEach(ExtensionContext context) throws Exception {

        var methodAnnotation = context.getRequiredTestMethod().getAnnotation(TestSql.class);

        if (methodAnnotation != null) {
            startContainer(methodAnnotation.value());
            currentConfig.set(datasourceConfiguration);
        }

    }

    protected  void startContainer(DatabaseType databaseType) {
        switch (databaseType){
            case MYSQL -> startMySQL();
            case ORACLE -> startOracle();
            case POSTGRES -> startPostgres();
        }
    }

    private  void startMySQL() {
        if (mySQLContainer == null) {
            mySQLContainer = new MySQLContainer<>("mysql:8.0")
                    .withDatabaseName(ContainerEnum.DATA_BASE.getProperty())
                    .withUsername(ContainerEnum.USER_NAME.getProperty())
                    .withPassword(ContainerEnum.PASSWORD.getProperty())
                    .withUrlParam("useSSL", "false")
                    .withUrlParam("allowPublicKeyRetrieval", "true")
                    .withInitScript("Create_DB.sql");
            mySQLContainer.start();
            datasourceConfiguration = DatasourceConfiguration.builder()
                    .withUrl(mySQLContainer.getJdbcUrl())
                    .withUser(mySQLContainer.getUsername())
                    .withPass(mySQLContainer.getPassword())
                    .build();
        }
    }
    
    private  void startPostgres(){
        if(postgreSQLContainer == null){
            postgreSQLContainer = new PostgreSQLContainer<>("postgres:16.2")
                    .withDatabaseName(ContainerEnum.DATA_BASE.getProperty())
                    .withUsername(ContainerEnum.USER_NAME.getProperty())
                    .withPassword(ContainerEnum.PASSWORD.getProperty())
                    .withInitScript("Postgres_DB.sql");
            
            postgreSQLContainer.start();
            datasourceConfiguration = DatasourceConfiguration.builder()
                    .withUrl(postgreSQLContainer.getJdbcUrl())
                    .withUser(postgreSQLContainer.getUsername())
                    .withPass(postgreSQLContainer.getPassword())
                    .build();
        }
    }

    private  void startOracle() {
        if (oracleContainer == null) {
            DockerImageName oracleImage = DockerImageName.parse("gvenzl/oracle-free:23-slim")
                    .asCompatibleSubstituteFor("gvenzl/oracle-xe");

            oracleContainer = new OracleContainer(oracleImage)
                    .withDatabaseName(ContainerEnum.DATA_BASE.getProperty())
                    .withUsername(ContainerEnum.USER_NAME.getProperty())
                    .withPassword(ContainerEnum.PASSWORD.getProperty())
                    .withInitScript("Plsql_DB.sql");
            oracleContainer.start();
            datasourceConfiguration = DatasourceConfiguration.builder()
                    .withUrl(oracleContainer.getJdbcUrl())
                    .withUser(oracleContainer.getUsername())
                    .withPass(oracleContainer.getPassword())
                    .build();
        }
    }


    public static class DatasourceConfiguration {
        private final String url;
        private final String user;
        private final String pass;

        private DatasourceConfiguration(String url, String user, String pass) {
            this.url = url;
            this.user = user;
            this.pass = pass;
        }

        public String getUrl() { return url; }
        public String getUser() { return user; }
        public String getPass() { return pass; }

        public static class Builder {
            private String url;
            private String user;
            private String pass;

            public Builder withUrl(String url) {
                this.url = url;
                return this;
            }

            public Builder withUser(String user) {
                this.user = user;
                return this;
            }

            public Builder withPass(String pass) {
                this.pass = pass;
                return this;
            }

            public DatasourceConfiguration build() {

                if (url == null || url.trim().isEmpty()) {
                    throw new IllegalStateException("URL não pode ser nula ou vazia");
                }

                return new DatasourceConfiguration(url, user, pass);
            }
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    public static DatasourceConfiguration getDatasourceConfiguration() {
        return datasourceConfiguration;
    }


}
