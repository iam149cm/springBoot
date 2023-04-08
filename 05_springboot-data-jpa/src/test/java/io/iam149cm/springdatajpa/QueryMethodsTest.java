package io.iam149cm.springdatajpa;

import io.iam149cm.springdatajpa.entity.Product;
import io.iam149cm.springdatajpa.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("iPhone 13 Pro");
        System.out.println("👉 "+ product.toString());
    }

    @Test
    void findByIdMethod() {
        Product product = productRepository.findById(14L).get();
        System.out.println("👉 "+ product.toString());
        System.out.println("👉 "+ product.getName());
    }

    @Test
    void findByNameOrDescriptionMethod() {
        List<Product> products = productRepository.findByNameOrDescription(
                "iPhone 13 PRO MAX",
                "Apple"
        );
        products.forEach((p) -> System.out.println("👉 "+ p.toString()));
    }

    @Test
    void findByNameAndDescriptionMethod() {
        List<Product> products = productRepository.findByNameAndDescription(
                "iPhone 13 PRO MAX",
                "Apple iPhone 13 PRO MAX"
        );
        products.forEach((p) -> System.out.println("👉 "+ p.toString()));
    }

    @Test
    void findDistinctByNameMethod() {
        Product product = productRepository.findDistinctByName("iPhone 13 PRO");
//        Product product = productRepository.findDistinctByName("iPhone 13 PRO MAX");
        System.out.println("👉 "+ product.toString());
    }

    @Test
    void findByPriceGreaterThanMethod() {
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(100));
        products.forEach((p) -> System.out.println("👉 "+ p.toString()));
    }

    @Test
    void findByPriceLessThanMethod() {
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(100));
        products.forEach((p) -> System.out.println("👉 "+ p.toString()));
    }
}
