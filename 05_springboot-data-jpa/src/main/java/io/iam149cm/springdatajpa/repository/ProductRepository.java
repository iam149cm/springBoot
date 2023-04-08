package io.iam149cm.springdatajpa.repository;

import io.iam149cm.springdatajpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// @Repository is not necessary
public interface ProductRepository extends JpaRepository<Product, Long> {

    /** Returns the found product entity by using its name as search criteria.
    * If no entity is found, this method returns null. */
    public Product findByName(String name);

    /** Returns an Optional which contains the found product entity by using its id as search criteria.
     * If no entity is found, this method returns an empty Optional. */
    Optional<Product> findById(Long id);

    /** Returns a List of product entities which name or/and description contains the given search term.
     * If no entity is found, this method returns an empty List. (The first letter of Search Criteria needs to be capitalized.) */
    List<Product> findByNameOrDescription(String name, String description);
    List<Product> findByNameAndDescription(String name, String description);



}
