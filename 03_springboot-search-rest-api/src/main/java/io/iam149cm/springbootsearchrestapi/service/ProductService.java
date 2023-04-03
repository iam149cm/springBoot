package io.iam149cm.springbootsearchrestapi.service;

import io.iam149cm.springbootsearchrestapi.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> searchProducts(String query);

    Product createProduct(Product product);
}
