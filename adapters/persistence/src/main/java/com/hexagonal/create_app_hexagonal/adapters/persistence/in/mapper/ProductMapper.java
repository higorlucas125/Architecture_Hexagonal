package com.hexagonal.create_app_hexagonal.adapters.persistence.in.mapper;

import com.hexagonal.create_app_hexagonal.adapters.persistence.in.entity.ConsumerEntity;
import com.hexagonal.create_app_hexagonal.adapters.persistence.in.entity.ProductEntity;
import com.hexagonal.create_app_hexagonal.application.domain.Product;

public class ProductMapper {

    public static ProductEntity.ProductEntityBuilder mapper(Product product){

        ConsumerEntity consumerEntity = null;

        if (product.getConsumerId() != null) {
            consumerEntity = ConsumerEntity.builder()
                    .withId(product.getConsumerId())
                    .build();
        }

        return ProductEntity.builder()
                .withName(product.getName())
                .withDescription(product.getDescription())
                .withSku(product.getSku())
                .withCategory(product.getCategory())
                .withPrice(product.getPrice())
                .withBrand(product.getBrand())
                .withWeight(product.getWeight())
                .withHeight(product.getHeight())
                .withWidth(product.getWidth())
                .withDepth(product.getDepth())
                .withConsumer(consumerEntity)
                .withActive(product.getActive());
    }

    public static ProductEntity mapperToEntity(Product product){
        return mapper(product).build();
    }

    public static Product mapperToDomain(ProductEntity entity){
        return Product.builder()
                .withId(entity.getId())
                .withName(entity.getName())
                .withDescription(entity.getDescription())
                .withSku(entity.getSku())
                .withCategory(entity.getCategory())
                .withPrice(entity.getPrice())
                .withQuantityInStock(entity.getQuantityInStock())
                .withActive(entity.getActive())
                .withBrand(entity.getBrand())
                .withWeight(entity.getWeight())
                .withHeight(entity.getHeight())
                .withWidth(entity.getWidth())
                .withDepth(entity.getDepth())
                .withCreatedAt(entity.getCreatedAt())
                .withUpdatedAt(entity.getUpdatedAt())
                .withConsumerId(entity.getConsumer() != null ? entity.getConsumer().getId() : null)
                .build();
    }
}
