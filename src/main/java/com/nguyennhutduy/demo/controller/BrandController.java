package com.nguyennhutduy.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nguyennhutduy.demo.entity.Brand;
import com.nguyennhutduy.demo.service.BrandService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/brands")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    // Create Brand
    // http://localhost:8081/api/brands
    @PostMapping
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
        Brand savedBrand = brandService.createBrand(brand);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBrand);
    }

    // Get Brand by ID
    // http://localhost:8081/api/brands/
    @GetMapping("{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable("id") Long brandId) {
        Brand brand = brandService.getBrandById(brandId);
        return ResponseEntity.ok(brand);
    }

    // Get All Brands
    // http://localhost:8081/api/brands/
    @GetMapping
    public ResponseEntity<List<Brand>> getAllBrand() {
        List<Brand> brands = brandService.getAllBrand();
        return ResponseEntity.ok(brands);
    }

    // Update Brand
    // http://localhost:8081/api/brands/
    @PutMapping("{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable("id") Long brandId, @RequestBody Brand brand) {
        brand.setId(brandId);
        Brand updatedBrand = brandService.updateBrand(brand);
        return ResponseEntity.ok(updatedBrand);
    }

    // Delete Brand
    // http://localhost:8081/api/brands/
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBrand(@PathVariable("id") Long brandId) {
        brandService.deleteBrand(brandId);
        return ResponseEntity.ok("Brand successfully deleted!");
    }
}
