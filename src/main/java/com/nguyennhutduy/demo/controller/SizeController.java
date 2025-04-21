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

import com.nguyennhutduy.demo.entity.Size;
import com.nguyennhutduy.demo.service.SizeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/sizes")
@RequiredArgsConstructor
public class SizeController {
    private final SizeService sizeService;

    // Create Size
    // http://localhost:8081/api/sizes
    @PostMapping
    public ResponseEntity<?> createSize(@RequestBody Size size) {
        try {
            Size savedSize = sizeService.createSize(size);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSize);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Create List Size
    // http://localhost:8081/api/sizes/list
    @PostMapping("/list")
    public ResponseEntity<?> createListSize(@RequestBody List<Size> size) {
        try {
            List<Size> savedSize = sizeService.createListSize(size);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSize);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Get Size by ID
    // http://localhost:8081/api/sizes/{id}
    @GetMapping("{id}")
    public ResponseEntity<?> getSizeById(@PathVariable("id") Long sizeId) {
        try {
            Size size = sizeService.getSizeById(sizeId);
            return ResponseEntity.ok(size);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Get All Sizes
    // http://localhost:8081/api/sizes/
    @GetMapping
    public ResponseEntity<?> getAllSize() {
        try {
            List<Size> sizes = sizeService.getAllSize();
            return ResponseEntity.ok(sizes);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Update Size
    // http://localhost:8081/api/sizes/{id}
    @PutMapping("{id}")
    public ResponseEntity<?> updateSize(@PathVariable("id") Long sizeId,
            @RequestBody Size size) {
        try {
            size.setId(sizeId);
            Size updatedSize = sizeService.updateSize(size);
            return ResponseEntity.ok(updatedSize);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Delete Size
    // http://localhost:8081/api/sizes/
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSize(@PathVariable("id") Long sizeId) {
        try {
            sizeService.deleteSize(sizeId);
            return ResponseEntity.ok("Size successfully deleted!");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }
}
