package com.hexagonal.create_app_hexagonal.adapters.persistence.out;

import com.hexagonal.create_app_hexagonal.adapters.persistence.in.mysql.repository.AddressRepository;
import com.hexagonal.create_app_hexagonal.application.domain.Address;
import com.hexagonal.create_app_hexagonal.application.in.AddressEntityPort;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AddressEntityPorts implements AddressEntityPort {

    private AddressRepository repository;

    @Override
    public Address findById(Long id) {
        return null;
    }

    @Override
    public List<Address> findByAll() {
        return List.of();
    }

    @Override
    public void save(Address address) {

    }

    @Override
    public void update(Address address, Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
