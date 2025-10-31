package com.hexagonal.create_app_hexagonal.application.out;

import com.hexagonal.create_app_hexagonal.application.domain.Consumer;
import com.hexagonal.create_app_hexagonal.application.domain.Product;

import java.util.List;

public interface InterfaceUseCase {

    void saveNewConsumer(Consumer consumer);

    List<Consumer> findAllConsumer();
}
