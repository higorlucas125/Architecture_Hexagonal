package com.hexagonal.create_app_hexagonal.adapters.persistence.in.mapper;

import com.hexagonal.create_app_hexagonal.adapters.persistence.in.domain.AddressEntity;
import com.hexagonal.create_app_hexagonal.adapters.persistence.in.domain.ConsumerEntity;
import com.hexagonal.create_app_hexagonal.application.domain.Address;

import java.util.Objects;

public class AddressMapper {

    public static AddressEntity.AddressEntityBuilder mapper(Address address){
        ConsumerEntity consumerEntity = null;

        if(Objects.nonNull(address.getConsumerId())){
            consumerEntity = ConsumerEntity.builder().withId(address.getConsumerId()).build();
        }

        return AddressEntity.builder()
                .withCity(address.getCity())
                .withComplement("");
    }

    public static AddressEntity mapToEntity(Address address){
        return mapper(address).build();
    }

    public static Address mapToDomain ( AddressEntity address){
        return Address.builder()
                .build();
    }

}
