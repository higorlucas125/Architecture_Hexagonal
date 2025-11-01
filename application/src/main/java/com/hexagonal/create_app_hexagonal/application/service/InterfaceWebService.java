package com.hexagonal.create_app_hexagonal.application.service;

import com.hexagonal.create_app_hexagonal.application.domain.Consumer;
import com.hexagonal.create_app_hexagonal.application.in.AddressEntityPort;
import com.hexagonal.create_app_hexagonal.application.in.ConsumerEntityPort;
import com.hexagonal.create_app_hexagonal.application.in.ProductEntityPort;
import com.hexagonal.create_app_hexagonal.application.out.InterfaceUseCase;
import com.hexagonal.create_app_hexagonal.communs.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class InterfaceWebService implements InterfaceUseCase {

    private final AddressEntityPort addressEntityPort;
    private final ConsumerEntityPort consumerEntityPort;
    private final ProductEntityPort productEntityPort;

    @Override
    public void saveNewConsumer(Consumer consumer) {

        consumer.getAddresses().stream().forEach(addressEntityPort::save);
        consumer.getProducts().stream().forEach(productEntityPort::save);

        consumerEntityPort.save(consumer);

    }

    @Override
    public List<Consumer> findAllConsumer() {
        return consumerEntityPort.findByAll();
    }
}

