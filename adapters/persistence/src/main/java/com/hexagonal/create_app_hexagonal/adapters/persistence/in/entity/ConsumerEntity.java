package com.hexagonal.create_app_hexagonal.adapters.persistence.in.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "consumer")
@Getter
@Builder(setterPrefix = "with",toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;                    // Identificador único do consumidor
    private String name;                // Nome completo
    private String cpf_or_cnpj;
    private String email;               // E-mail de contato
    private String phoneNumber;         // Telefone de contato

    @OneToMany(mappedBy = "consumer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AddressEntity> addressEntities;

    @OneToMany(mappedBy = "consumer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProductEntity> productEntities;
}
