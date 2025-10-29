package com.hexagonal.create_app_hexagonal.adapters.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/web")
public class ControllerTest {

    @GetMapping
    public ResponseEntity<?> getTestUnit() {
        var message = "Funcionando";
        return ResponseEntity.ok(message);
    }

}
