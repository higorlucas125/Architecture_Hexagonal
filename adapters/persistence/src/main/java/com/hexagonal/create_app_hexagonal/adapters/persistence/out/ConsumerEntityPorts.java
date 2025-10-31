package com.hexagonal.create_app_hexagonal.adapters.persistence.out;

import com.hexagonal.create_app_hexagonal.adapters.persistence.in.mysql.repository.ConsumerRepository;
import com.hexagonal.create_app_hexagonal.application.domain.Consumer;
import com.hexagonal.create_app_hexagonal.application.in.ConsumerEntityPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ConsumerEntityPorts implements ConsumerEntityPort {

    private ConsumerRepository repository;

    @Override
    public Consumer findById(Long id) {
        return null;
    }

    @Override
    public List<Consumer> findByAll() {
        return List.of();
    }

    @Override
    public void save(Consumer consumer) {

    }

    @Override
    public void update(Consumer consumer, Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
