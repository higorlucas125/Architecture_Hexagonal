package com.hexagonal.create_app_hexagonal.adapters.persistence.in.mysql.repository;

import com.hexagonal.create_app_hexagonal.adapters.persistence.in.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,Long> {
}
