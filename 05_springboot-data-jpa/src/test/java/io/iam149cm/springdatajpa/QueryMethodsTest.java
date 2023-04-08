package io.iam149cm.springdatajpa;

import io.iam149cm.springdatajpa.entity.Product;
import io.iam149cm.springdatajpa.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
