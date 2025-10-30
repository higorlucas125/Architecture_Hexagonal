package com.hexagonal.create_app_hexagonal.adapters.persistence.in.mapper;

import com.hexagonal.create_app_hexagonal.adapters.persistence.in.domain.ProductEntity;
import com.hexagonal.create_app_hexagonal.application.domain.Product;

public class ProductMapper {

    public static ProductEntity mapperToEntity(Product product){
        return ProductEntity.builder()
                .withId(product.getId())
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
                .withActive(product.getActive())
                .build();
    }

    public static Product mapperToDomain(ProductEntity product){
        return Product.builder().build();
    }
}
