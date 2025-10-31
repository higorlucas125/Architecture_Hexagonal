package com.hexagonal.create_app_hexagonal.adapters.persistence.in.mysql.repository;

import com.hexagonal.create_app_hexagonal.adapters.persistence.in.domain.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity,Long> {
}
