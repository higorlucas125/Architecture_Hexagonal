package com.hexagonal.create_app_hexagonal.adapters.persistence.out;

import com.hexagonal.create_app_hexagonal.adapters.persistence.in.mysql.repository.ConsumerRepository;
import com.hexagonal.create_app_hexagonal.application.domain.Consumer;
import com.hexagonal.create_app_hexagonal.application.in.ConsumerEntityPort;
import com.hexagonal.create_app_hexagonal.adapters.persistence.in.mapper.ConsumerMapper;
import com.hexagonal.create_app_hexagonal.communs.Persistence;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.hexagonal.create_app_hexagonal.adapters.persistence.in.mapper.ConsumerMapper.mapToDomain;

@Persistence
@RequiredArgsConstructor
public class ConsumerEntityPorts implements ConsumerEntityPort {


    private final ConsumerRepository repository;

    @Override
    public Consumer findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consumidor não encontrado"));
        return mapToDomain(entity);
    }

    @Override
    public List<Consumer> findByAll() {
        return repository.findAll().stream()
                .map(ConsumerMapper::mapToDomain)
                .toList();
    }

    @Override
    public void save(Consumer consumer) {
        var entity = ConsumerMapper.mapper(consumer).build();
        repository.save(entity);
    }

    @Override
    public void update(Consumer consumer, Long id) {
        var existingEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consumidor não encontrado"));

        var updatedEntityBuilder = ConsumerMapper.mapper(consumer)
                .withId(existingEntity.getId());

        var updatedEntity = updatedEntityBuilder.build();
        repository.save(updatedEntity);
    }

    @Override
    public void delete(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consumidor não encontrado"));
        repository.deleteById(entity.getId());
    }
}
