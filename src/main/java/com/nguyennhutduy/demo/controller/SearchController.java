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

import com.nguyennhutduy.demo.entity.Search;
import com.nguyennhutduy.demo.service.SearchService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/searchs")
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;

    // Create Search
    // http://localhost:8081/api/searchs
    @PostMapping
    public ResponseEntity<?> createSearch(@RequestBody Search search) {
        try {
            Search savedSearch = searchService.createSearch(search);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSearch);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Get Search by ID
    // http://localhost:8081/api/searchs/{id}
    @GetMapping("{id}")
    public ResponseEntity<?> getSearchById(@PathVariable("id") Long searchId) {
        try {
            Search search = searchService.getSearchById(searchId);
            return ResponseEntity.ok(search);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Get All Searchs
    // http://localhost:8081/api/searchs/
    @GetMapping
    public ResponseEntity<?> getAllSearch() {
        try {
            List<Search> searchs = searchService.getAllSearch();
            return ResponseEntity.ok(searchs);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Update Search
    // http://localhost:8081/api/searchs/{id}
    @PutMapping("{id}")
    public ResponseEntity<?> updateSearch(@PathVariable("id") Long searchId,
            @RequestBody Search search) {
        try {
            search.setId(searchId);
            Search updatedSearch = searchService.updateSearch(search);
            return ResponseEntity.ok(updatedSearch);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Delete Search
    // http://localhost:8081/api/searchs/
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSearch(@PathVariable("id") Long searchId) {
        try {
            searchService.deleteSearch(searchId);
            return ResponseEntity.ok("Search successfully deleted!");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }
}
