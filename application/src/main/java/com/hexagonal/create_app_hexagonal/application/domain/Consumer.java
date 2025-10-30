package com.hexagonal.create_app_hexagonal.application.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Builder(setterPrefix = "with",toBuilder = true)
@Getter
public class Consumer {

    private Long id;                    // Identificador único do consumidor
    private String name;                // Nome completo
    private String cpf_or_cnpj;
    private String email;               // E-mail de contato
    private String phoneNumber;         // Telefone de contato
    private List<Product> products;     // Lista de produtos relacionados (comprados, favoritos, etc.)
    private List<Address> addresses;    // Lista de endereços do consumidor
}
