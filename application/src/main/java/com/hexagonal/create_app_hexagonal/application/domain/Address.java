package com.hexagonal.create_app_hexagonal.application.domain;

import com.hexagonal.create_app_hexagonal.application.domain.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@AllArgsConstructor
@Builder(setterPrefix = "with",toBuilder = true)
@Getter
public class Address {

    private Long id;              // Identificador único do endereço
    private String street;        // Rua / Logradouro
    private String number;        // Número
    private String complement;    // Complemento (ex: Apto 101, Bloco B)
    private String neighborhood;  // Bairro
    private String city;          // Cidade
    private State state;         // Estado (ex: SP, MG)
    private String country;       // País
    private String zipCode;       // CEP
    private Boolean mainAddress;  // Indica se é o endereço principal
}
