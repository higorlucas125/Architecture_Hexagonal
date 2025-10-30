package com.hexagonal.create_app_hexagonal.adapters.persistence.in.domain;

import jakarta.persistence.Entity;
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

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@Getter
@Builder(setterPrefix = "with",toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;                        // Identificador único do produto
    private String name;                    // Nome do produto
    private String description;             // Descrição detalhada
    private String sku;                     // Código interno ou SKU (Stock Keeping Unit)
    private String category;                // Categoria (ex: Eletrônicos, Vestuário)
    private BigDecimal price;               // Preço unitário
    private Integer quantityInStock;        // Quantidade disponível em estoque
    private Boolean active;                 // Se o produto está ativo ou não
    private String brand;                   // Marca do produto
    private Double weight;                  // Peso (kg)
    private Double height;                  // Altura (cm)
    private Double width;                   // Largura (cm)
    private Double depth;                   // Profundidade (cm)
    private LocalDateTime createdAt;        // Data/hora de criação
    private LocalDateTime updatedAt;        // Data/hora da última atualização

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consumer_id")
    private ConsumerEntity consumerEntity;
}
