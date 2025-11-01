package com.hexagonal.create_app_hexagonal.adapters.persistence.in.mapper;

import com.hexagonal.create_app_hexagonal.adapters.persistence.in.entity.AddressEntity;
import com.hexagonal.create_app_hexagonal.adapters.persistence.in.entity.ConsumerEntity;
import com.hexagonal.create_app_hexagonal.adapters.persistence.in.entity.ProductEntity;
import com.hexagonal.create_app_hexagonal.application.domain.Address;
import com.hexagonal.create_app_hexagonal.application.domain.Consumer;
import com.hexagonal.create_app_hexagonal.application.domain.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ConsumerMapper {

    public static ConsumerEntity.ConsumerEntityBuilder mapper(Consumer consumer){

        if (consumer == null) {
            return null;
        }

        List<AddressEntity> addressEntities = null;
        if (consumer.getAddresses() != null && !consumer.getAddresses().isEmpty()) {
            addressEntities = consumer.getAddresses().stream()
                    .map(AddressMapper::mapToEntity)
                    .collect(Collectors.toList());
        }

        List<ProductEntity> productEntities = null;
        if (consumer.getProducts() != null && !consumer.getProducts().isEmpty()) {
            productEntities = consumer.getProducts().stream()
                    .map(ProductMapper::mapperToEntity)
                    .collect(Collectors.toList());
        }

        return ConsumerEntity.builder()
                .withName(consumer.getName())
                .withCpf_or_cnpj(consumer.getCpf_or_cnpj())
                .withEmail(consumer.getEmail())
                .withPhoneNumber(consumer.getPhoneNumber())
                .withAddressEntities(addressEntities)
                .withProductEntities(productEntities);

    }

    public static ConsumerEntity mapToEntity(Consumer consumer){
        return mapper(consumer).build();
    }

    public static Consumer mapToDomain(ConsumerEntity entity){
        if (entity == null) {
            return null;
        }

        List<Address> addresses = null;
        if (entity.getAddressEntities() != null && !entity.getAddressEntities().isEmpty()) {
            addresses = entity.getAddressEntities().stream()
                    .map(AddressMapper::mapToDomain)
                    .collect(Collectors.toList());
        }

        List<Product> products = null;
        if (entity.getProductEntities() != null && !entity.getProductEntities().isEmpty()) {
            products = entity.getProductEntities().stream()
                    .map(ProductMapper::mapperToDomain)
                    .collect(Collectors.toList());
        }

        return Consumer.builder()
                .withId(entity.getId())
                .withName(entity.getName())
                .withCpf_or_cnpj(entity.getCpf_or_cnpj())
                .withEmail(entity.getEmail())
                .withPhoneNumber(entity.getPhoneNumber())
                .withAddresses(addresses)
                .withProducts(products)
                .build();
    }
}
