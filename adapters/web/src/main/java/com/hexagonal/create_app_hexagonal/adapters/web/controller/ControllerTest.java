package com.hexagonal.create_app_hexagonal.adapters.web.controller;

import com.hexagonal.create_app_hexagonal.application.domain.Consumer;
import com.hexagonal.create_app_hexagonal.application.out.InterfaceUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/web")
public class ControllerTest {

    @Autowired
    private InterfaceUseCase interfaceUseCase;

    @GetMapping
    public ResponseEntity<?> getTestUnit() {
        var message = "Funcionando";
        return ResponseEntity.ok(message);
    }

    @GetMapping("/consumer")
    public ResponseEntity<List<Consumer>> getAllConsumer(){
        return ResponseEntity.ok(interfaceUseCase.findAllConsumer());
    }

}
