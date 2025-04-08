package com.nguyennhutduy.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nguyennhutduy.demo.entity.Cart;
import com.nguyennhutduy.demo.service.CartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    // Create Cart
    // http://localhost:8081/api/carts
    @PostMapping
    public ResponseEntity<?> createCart(@RequestBody Cart cart) {
        try {
            Cart savedCart = cartService.createCart(cart);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCart);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Get Cart by ID
    // http://localhost:8081/api/carts/{id}
    @GetMapping("{id}")
    public ResponseEntity<?> getCartById(@PathVariable("id") Long cartId) {
        try {
            Cart cart = cartService.getCartById(cartId);
            return ResponseEntity.ok(cart);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Get All Carts
    // http://localhost:8081/api/carts/
    @GetMapping
    public ResponseEntity<?> getAllCart() {
        try {
            List<Cart> carts = cartService.getAllCart();
            return ResponseEntity.ok(carts);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }
}
