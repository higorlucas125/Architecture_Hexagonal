package com.hexagonal.create_app_hexagonal.adapters.persistence.in.mysql.repository;

import com.hexagonal.create_app_hexagonal.adapters.persistence.in.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
