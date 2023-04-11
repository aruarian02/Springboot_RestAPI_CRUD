package org.youtube.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.youtube.restapi.data.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

}
