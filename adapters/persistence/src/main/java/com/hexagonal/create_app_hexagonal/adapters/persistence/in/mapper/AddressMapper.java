package com.hexagonal.create_app_hexagonal.adapters.persistence.in.mapper;

import com.hexagonal.create_app_hexagonal.adapters.persistence.in.entity.AddressEntity;
import com.hexagonal.create_app_hexagonal.adapters.persistence.in.entity.ConsumerEntity;
import com.hexagonal.create_app_hexagonal.application.domain.Address;
import com.hexagonal.create_app_hexagonal.adapters.persistence.in.entity.enums.State;
import java.util.Objects;

import static com.hexagonal.create_app_hexagonal.adapters.persistence.utils.EnumsMapper.mapEnum;

public class AddressMapper {

    public static AddressEntity.AddressEntityBuilder mapper(Address address){
        ConsumerEntity consumerEntity = null;

        if (Objects.nonNull(address.getConsumerId())) {
            consumerEntity = ConsumerEntity.builder()
                    .withId(address.getConsumerId())
                    .build();
        }

        return AddressEntity.builder()
                .withStreet(address.getStreet())
                .withNumber(address.getNumber())
                .withComplement(address.getComplement())
                .withNeighborhood(address.getNeighborhood())
                .withCity(address.getCity())
                .withState(mapEnum(address.getState(),State.class))
                .withCountry(address.getCountry())
                .withZipCode(address.getZipCode())
                .withMainAddress(address.getMainAddress())
                .withConsumer(consumerEntity);
    }

    public static AddressEntity mapToEntity(Address address){
        return mapper(address).build();
    }

    public static Address mapToDomain ( AddressEntity address){
        return Address.builder()
                .withId(address.getId())
                .withStreet(address.getStreet())
                .withNumber(address.getNumber())
                .withComplement(address.getComplement())
                .withNeighborhood(address.getNeighborhood())
                .withCity(address.getCity())
                .withState(mapEnum(address.getState(), com.hexagonal.create_app_hexagonal.application.domain.enums.State.class))
                .withCountry(address.getCountry())
                .withZipCode(address.getZipCode())
                .withMainAddress(address.getMainAddress())
                .withConsumerId(address.getConsumer().getId())
                .build();
    }

}
