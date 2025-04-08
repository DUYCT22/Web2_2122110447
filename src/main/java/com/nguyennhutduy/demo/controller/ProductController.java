package com.nguyennhutduy.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nguyennhutduy.demo.entity.Product;
import com.nguyennhutduy.demo.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    // Create Product
    // http://localhost:8081/api/products
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        try {
            Product savedProduct = productService.createProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Get Product by ID
    // http://localhost:8081/api/products/{id}
    @GetMapping("{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Long productId) {
        try {
            Product product = productService.getProductById(productId);
            return ResponseEntity.ok(product);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Get All Products
    // http://localhost:8081/api/products/
    @GetMapping
    public ResponseEntity<?> getAllProduct() {
        try {
            List<Product> products = productService.getAllProduct();
            return ResponseEntity.ok(products);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Update Product
    // http://localhost:8081/api/products/{id}
    @PutMapping("{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") Long productId,
            @RequestBody Product category) {
        try {
            category.setId(productId);
            Product updatedProduct = productService.updateProduct(category);
            return ResponseEntity.ok(updatedProduct);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Delete Product
    // http://localhost:8081/api/products/
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long productId) {
        try {
            productService.deleteProduct(productId);
            return ResponseEntity.ok("Product successfully deleted!");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }
}
