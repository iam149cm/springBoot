package io.iam149cm.springdatajpa.repository;

import io.iam149cm.springdatajpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

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

    @Test
    void findByIdMethod() {
        long id = 1;
        Product product = repository.findById(id).get();
        System.out.println(product.toString());
    }

    @Test
    void saveAllMethod() {
        Product product1 = new Product();
        product1.setName("iPhone 13");
        product1.setDescription("Apple iPhone 13");
        product1.setSku("IPHONE13");
        product1.setPrice(new BigDecimal(999.99));
        product1.setActive(true);
        product1.setImageUrl("https://www.apple.com/iphone-13/");

        Product product2 = new Product();
        product2.setName("iPhone 13 PRO");
        product2.setDescription("Apple iPhone 13 PRO");
        product2.setSku("IPHONE13PRO");
        product2.setPrice(new BigDecimal(999.99));
        product2.setActive(true);
        product2.setImageUrl("https://www.apple.com/iphone-13/");

        Product product3 = new Product();
        product3.setName("iPhone 13 PRO MAX");
        product3.setDescription("Apple iPhone 13 PRO MAX");
        product3.setSku("IPHONE13PROMAX");
        product3.setPrice(new BigDecimal(999.99));
        product3.setActive(true);
        product3.setImageUrl("https://www.apple.com/iphone-13/");

        repository.saveAll(List.of(product1, product2, product3));
    }

    @Test
    void findAllMethod(){
        List<Product> products = repository.findAll();
        products.forEach((p) -> {
            System.out.println("👉 "+p.getName());
        });
    }

    @Test
    void deleteByIdMethod(){
        long id = 1;
        repository.deleteById(id);
    }

    @Test
    void deleleMethod(){
        // find an entity by id
        long id = 2;
        Product product = repository.findById(id).get();

        // delete entity
        repository.delete(product);
    }

    @Test
    void deleteAllMethod(){
//        repository.deleteAll(); // delete all entities

        Product product1 = repository.findById(6L).get();
        Product product2 = repository.findById(7L).get();
        repository.deleteAll(List.of(product1, product2)); // delete all entities in the list
    }

    @Test
    void countMethod(){
        long count = repository.count();
        System.out.println("Total number of products: " + count);
    }

    @Test
    void existsByIdMethod(){
        long id = 14;
        boolean exists = repository.existsById(id);
        System.out.println("Product with id " + id + " 👉 exists: " + exists);
    }


}