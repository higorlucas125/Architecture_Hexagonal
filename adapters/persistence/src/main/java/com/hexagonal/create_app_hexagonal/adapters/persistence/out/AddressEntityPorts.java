package com.hexagonal.create_app_hexagonal.adapters.persistence.out;

import com.hexagonal.create_app_hexagonal.adapters.persistence.in.mapper.AddressMapper;
import com.hexagonal.create_app_hexagonal.adapters.persistence.in.repository.AddressRepository;
import com.hexagonal.create_app_hexagonal.application.domain.Address;
import com.hexagonal.create_app_hexagonal.application.in.AddressEntityPort;
import com.hexagonal.create_app_hexagonal.communs.Persistence;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Persistence
@RequiredArgsConstructor
public class AddressEntityPorts implements AddressEntityPort {

    private final AddressRepository repository;

    @Override
    public Address findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        return AddressMapper.mapToDomain(entity);
    }

    @Override
    public List<Address> findByAll() {
        return repository.findAll().stream()
                .map(AddressMapper::mapToDomain)
                .toList();
    }

    @Override
    public void save(Address address) {
        var entity = AddressMapper.mapToEntity(address);
        repository.save(entity);
    }

    @Override
    public void update(Address address, Long id) {
        var existingEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));

        var updatedEntity = AddressMapper.mapToEntity(address);
        updatedEntity.setId(existingEntity.getId());
        repository.save(updatedEntity);
    }

    @Override
    public void delete(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        repository.deleteById(entity.getId());
    }
}
