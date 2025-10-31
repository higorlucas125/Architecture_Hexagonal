package com.hexagonal.create_app_hexagonal.adapters.persistence.in.mysql.repository;

import com.hexagonal.create_app_hexagonal.adapters.persistence.in.domain.ConsumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerRepository extends JpaRepository<ConsumerEntity,Long> {
}
