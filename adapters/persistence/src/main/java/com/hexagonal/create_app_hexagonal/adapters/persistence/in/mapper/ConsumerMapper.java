package com.hexagonal.create_app_hexagonal.adapters.persistence.in.mapper;

import com.hexagonal.create_app_hexagonal.adapters.persistence.in.domain.AddressEntity;
import com.hexagonal.create_app_hexagonal.adapters.persistence.in.domain.ConsumerEntity;
import com.hexagonal.create_app_hexagonal.adapters.persistence.in.domain.ProductEntity;
import com.hexagonal.create_app_hexagonal.application.domain.Consumer;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConsumerMapper {

    public static ConsumerEntity.ConsumerEntityBuilder mapper(Consumer consumer){

        List<AddressEntity> addressEntities = null;
        List<ProductEntity> productEntities = null;

        if(consumer.getAddresses().size() > 0 && consumer.getProducts().size() > 0 ){

            addressEntities = consumer.getAddresses().stream().map( address -> AddressMapper.mapToEntity(address)).toList();
            productEntities = consumer.getProducts().stream().map( products -> ProductMapper.mapperToEntity(products)).toList();

        }

        return ConsumerEntity.builder()
                .withAddressEntities(addressEntities)
                .withProductEntities(productEntities);

    }
}
