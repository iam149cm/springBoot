package io.iam149cm.springdatajpa.repository;

import io.iam149cm.springdatajpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // to load the application context to excute a piece of code for testing
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    void saveMethod(){
        // create product
        Product product = new Product();
        product.setName("iPhone 12");
        product.setDescription("Apple iPhone 12");
        product.setSku("IPHONE12");
        product.setPrice(new BigDecimal(999.99));
        product.setActive(true);
        product.setImageUrl("https://www.apple.com/iphone-12/");

        // save product to database
        Product savedProduct = repository.save(product);

        // display product information
        System.out.println(savedProduct.toString());
    }

    @Test
    void updateUsingSaveMethod() {
        // find or retrieve product from database by id
        long id = 1;
        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // update entity information
        product.setName("iPhone 12 Pro");
        product.setDescription("Apple iPhone 12 Pro");

        // save entity to database
        Product savedProduct = repository.save(product);
    }
}