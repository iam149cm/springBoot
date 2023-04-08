package io.iam149cm.springdatajpa.repository;

import io.iam149cm.springdatajpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    /** Returns a distinct product entity by using its name as search criteria.
     * If no entity is found, this method returns null.
     */
    Product findDistinctByName(String name);

    // Returns a List of product entities which price is greater/less than the given search term.
    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceLessThan(BigDecimal price);

    // Returns a List of product entities which name contains the given search term.
    List<Product> findByNameContaining(String name);

    // Returns a List of product entities based on SQL LIKE clause.
    List<Product> findByNameLike(String name);

    // Returns a List of product entities which price is between the given search term.
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);
    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Returns a List of product entities which name is in the given search term. (SQL IN clause)
    List<Product> findByNameIn(List<String> names);

    // fetch all products by name in ascending order (SQL ORDER BY, LIMIT clause)
    List<Product> findFirst2ByOrderByNameAsc();
    List<Product> findTop3ByOrderByPriceDesc();


}
