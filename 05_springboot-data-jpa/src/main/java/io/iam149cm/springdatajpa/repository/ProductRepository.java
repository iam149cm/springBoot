package io.iam149cm.springdatajpa.repository;

import io.iam149cm.springdatajpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository is not necessary
public interface ProductRepository extends JpaRepository<Product, Long> {


}
