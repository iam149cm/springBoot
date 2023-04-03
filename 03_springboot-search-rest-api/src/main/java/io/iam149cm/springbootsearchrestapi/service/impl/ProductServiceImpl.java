package io.iam149cm.springbootsearchrestapi.service.impl;

import io.iam149cm.springbootsearchrestapi.entity.Product;
import io.iam149cm.springbootsearchrestapi.repository.ProductRepository;
import io.iam149cm.springbootsearchrestapi.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> searchProducts(String query) {
        List<Product> products = productRepository.searchProducts(query);
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
