package io.iam149cm.springdatajpa.repository;

import io.iam149cm.springdatajpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// @Repository is not necessary
public interface ProductRepository extends JpaRepository<Product, Long> {

    /** Returns the found product entity by using its name as search criteria.
    * If no entity is found, this method returns null. */
    public Product findByName(String name);

    /** Returns an Optional which contains the found product entity by using its id as search criteria.
     * If no entity is found, this method returns an empty Optional. */
    Optional<Product> findById(Long id);



}
