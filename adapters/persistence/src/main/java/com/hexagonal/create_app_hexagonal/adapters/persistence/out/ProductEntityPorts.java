package com.hexagonal.create_app_hexagonal.adapters.persistence.out;


import com.hexagonal.create_app_hexagonal.adapters.persistence.in.repository.ProductRepository;
import com.hexagonal.create_app_hexagonal.application.domain.Product;
import com.hexagonal.create_app_hexagonal.application.in.ProductEntityPort;
import com.hexagonal.create_app_hexagonal.communs.Persistence;
import lombok.RequiredArgsConstructor;


import java.util.List;

import static com.hexagonal.create_app_hexagonal.adapters.persistence.in.mapper.ProductMapper.*;

@Persistence
@RequiredArgsConstructor
public class ProductEntityPorts implements ProductEntityPort {

    private final ProductRepository repository;

    @Override
    public Product findById(Long id) {
        var productEntity = repository.findById( id ).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        return mapperToDomain(productEntity);
    }

    @Override
    public List<Product> findByAll() {
        var listProduct = repository.findAll();
        return listProduct.stream().map(productEntity -> mapperToDomain(productEntity)).toList();
    }

    @Override
    public void save(Product product) {
        var productEntity = mapperToEntity(product);
        repository.save(productEntity);
    }

    @Override
    public void update(Product product, Long id) {
        var existing = findById(id);

        var updated = mapper(product);
        updated.withId(existing.getId());
        repository.save(updated.build());
    }

    @Override
    public void delete(Long id) {
        var domain = findById(id);

        repository.deleteById(domain.getId());
    }
}
