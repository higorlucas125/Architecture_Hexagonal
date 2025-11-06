package com.hexagonal.create_app_hexagonal.adapters.persistence.suporte;

public enum SpringDatasource {
    URL("spring.datasource.url"),
    USER_NAME("spring.datasource.username"),
    PASSWORD("spring.datasource.password");

    private final String property;

    private SpringDatasource(String property){
        this.property =property;
    }

    public String getProperty(){
        return property;
    }
}
