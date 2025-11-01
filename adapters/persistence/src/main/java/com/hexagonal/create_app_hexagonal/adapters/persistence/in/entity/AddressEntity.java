package com.hexagonal.create_app_hexagonal.adapters.persistence.in.entity;

import com.hexagonal.create_app_hexagonal.adapters.persistence.in.entity.enums.State;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;


@Entity
@Table(name = "address")
@Getter
@Setter
@Builder(setterPrefix = "with",toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;              // Identificador único do endereço

    @NonNull
    private String street;        // Rua / Logradouro
    @NonNull
    private String number;        // Número
    private String complement;    // Complemento (ex: Apto 101, Bloco B)
    @NonNull
    private String neighborhood;  // Bairro
    @NonNull
    private String city;          // Cidade
    @NonNull
    @Enumerated(EnumType.STRING)
    private State state;         // Estado (ex: SP, MG)
    @NonNull
    private String country;       // País
    private String zipCode;       // CEP
    private Boolean mainAddress;  // Indica se é o endereço principal

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consumer_id")
    private ConsumerEntity consumer;
}
