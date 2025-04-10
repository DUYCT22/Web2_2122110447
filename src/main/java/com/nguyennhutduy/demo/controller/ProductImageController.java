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

import com.nguyennhutduy.demo.entity.ProductImages;
import com.nguyennhutduy.demo.service.ProductImageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/productImages")
@RequiredArgsConstructor
public class ProductImageController {
    private final ProductImageService productImageService;

    // Create ProductImage
    // http://localhost:8081/api/productImages
    @PostMapping
    public ResponseEntity<?> createProductImage(@RequestBody ProductImages productImage) {
        try {
            ProductImages savedProductImage = productImageService.createProductImage(productImage);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProductImage);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Get ProductImage by ID
    // http://localhost:8081/api/productImages/{id}
    @GetMapping("{id}")
    public ResponseEntity<?> getProductImageById(@PathVariable("id") Long productImageId) {
        try {
            ProductImages productImage = productImageService.getProductImageById(productImageId);
            return ResponseEntity.ok(productImage);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Get All ProductImages
    // http://localhost:8081/api/productImages/
    @GetMapping
    public ResponseEntity<?> getAllProductImage() {
        try {
            List<ProductImages> productImages = productImageService.getAllProductImage();
            return ResponseEntity.ok(productImages);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Update ProductImage
    // http://localhost:8081/api/productImages/{id}
    @PutMapping("{id}")
    public ResponseEntity<?> updateProductImage(@PathVariable("id") Long productImageId,
            @RequestBody ProductImages productImage) {
        try {
            productImage.setId(productImageId);
            ProductImages updatedProductImage = productImageService.updateProductImage(productImage);
            return ResponseEntity.ok(updatedProductImage);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Delete ProductImage
    // http://localhost:8081/api/productImages/
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProductImage(@PathVariable("id") Long productImageId) {
        try {
            productImageService.deleteProductImage(productImageId);
            return ResponseEntity.ok("ProductImage successfully deleted!");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }
}
