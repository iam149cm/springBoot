package io.iam149cm.springbootsearchrestapi.repository;

import io.iam149cm.springbootsearchrestapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
