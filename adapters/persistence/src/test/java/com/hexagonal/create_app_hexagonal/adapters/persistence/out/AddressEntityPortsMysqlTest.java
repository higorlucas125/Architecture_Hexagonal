package com.hexagonal.create_app_hexagonal.adapters.persistence.out;

import com.hexagonal.create_app_hexagonal.adapters.persistence.suporte.MysqlTestContainerConfig;
import com.hexagonal.create_app_hexagonal.adapters.persistence.PersistenceTestConfig;
import com.hexagonal.create_app_hexagonal.application.in.AddressEntityPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest(classes = PersistenceTestConfig.class)
public class AddressEntityPortsMysqlTest extends MysqlTestContainerConfig {

    @Autowired
    private AddressEntityPort addressEntityPort;

    @Test
    @DisplayName("Given Find All When call Address Then return Address List")
    public void givenFindAllWhenCallAddressThenReturnAddressList(){
        var addresList = addressEntityPort.findByAll();

        assertFalse(CollectionUtils.isEmpty(addresList));

    }
}
