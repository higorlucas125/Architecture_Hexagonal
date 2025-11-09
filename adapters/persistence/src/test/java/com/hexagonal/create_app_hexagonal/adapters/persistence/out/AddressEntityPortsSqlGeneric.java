package com.hexagonal.create_app_hexagonal.adapters.persistence.out;

import com.hexagonal.create_app_hexagonal.adapters.persistence.PersistenceTestConfig;
import com.hexagonal.create_app_hexagonal.adapters.persistence.suporte.testContainerConfig.DatabaseType;
import com.hexagonal.create_app_hexagonal.adapters.persistence.suporte.testContainerConfig.MultiDatabaseTest;
import com.hexagonal.create_app_hexagonal.adapters.persistence.suporte.testContainerConfig.TestSql;
import com.hexagonal.create_app_hexagonal.application.in.AddressEntityPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest(classes = PersistenceTestConfig.class)
public class AddressEntityPortsSqlGeneric extends MultiDatabaseTest {

    @Autowired
    private AddressEntityPort addressEntityPort;


    @Test
    @TestSql(DatabaseType.MYSQL)
    @DisplayName("Given Find All When call Address Then return Address List With Mysql")
    public void givenFindAllWhenCallAddressThenReturnAddressListMysql(){
        var addresList = addressEntityPort.findByAll();

        assertFalse(CollectionUtils.isEmpty(addresList));

    }

    @Test
    @TestSql(DatabaseType.ORACLE)
    @DisplayName("Given Find All When call Address Then return Address List With Oracle")
    public void givenFindAllWhenCallAddressThenReturnAddressListOracle(){
        var addresList = addressEntityPort.findByAll();

        assertFalse(CollectionUtils.isEmpty(addresList));

    }

    @Test
    @TestSql(DatabaseType.POSTGRES)
    @DisplayName("Given Find All When call Address Then return Address List With Postgres")
    public void givenFindAllWhenCallAddressThenReturnAddressListPostgres(){
        var addresList = addressEntityPort.findByAll();

        assertFalse(CollectionUtils.isEmpty(addresList));

    }
}
