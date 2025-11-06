package com.hexagonal.create_app_hexagonal.adapters.persistence.suporte;

public enum ContainerEnum {
    DATA_BASE("testdb"),
    USER_NAME("test"),
    PASSWORD("test");

    private final String property;

    private ContainerEnum(String property){
        this.property =property;
    }

    public String getProperty(){
        return property;
    }
}
