package io.iam149cm.springbootsearchrestapi.controller;

import io.iam149cm.springbootsearchrestapi.entity.Product;
import io.iam149cm.springbootsearchrestapi.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query) {
        List<Product> products = productService.searchProducts(query);
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

}
