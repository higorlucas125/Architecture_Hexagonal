package com.hexagonal.create_app_hexagonal.application.in;

public interface GenericEntityPort <T>{

    T findById(Long id);
    java.util.List<T> findByAll();
    void save(T entity);
    void update(T entity, Long id);
    void delete(Long id);
}
