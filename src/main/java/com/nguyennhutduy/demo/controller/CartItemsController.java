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

import com.nguyennhutduy.demo.entity.CartItems;
import com.nguyennhutduy.demo.service.CartItemsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/cartItems")
@RequiredArgsConstructor
public class CartItemsController {
    private final CartItemsService cartItemsService;

    // Create CartItems
    // http://localhost:8081/api/cartItems
    @PostMapping
    public ResponseEntity<?> createCartItem(@RequestBody CartItems cartItem) {
        try {
            CartItems savedCartItem = cartItemsService.createCartItem(cartItem);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCartItem);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Get CartItem by ID
    // http://localhost:8081/api/cartItems/
    @GetMapping("{id}")
    public ResponseEntity<?> getCartItemById(@PathVariable("id") Long CartItemId) {
        try {
            CartItems cartItem = cartItemsService.getCartItemById(CartItemId);
            return ResponseEntity.ok(cartItem);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Get All CartItems
    // http://localhost:8081/api/cartItems/
    @GetMapping
    public ResponseEntity<?> getAllCartItems() {
        try {
            List<CartItems> cartItems = cartItemsService.getAllCartItems();
            return ResponseEntity.ok(cartItems);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Update CartItems
    // http://localhost:8081/api/cartItems/
    @PutMapping("{id}")
    public ResponseEntity<?> updateCartItem(@PathVariable("id") Long cartItemId,
            @RequestBody CartItems cartItem) {
        try {
            cartItem.setId(cartItemId);
            CartItems updatedCartItem = cartItemsService.updateCartItem(cartItem);
            return ResponseEntity.ok(updatedCartItem);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Delete CartItems
    // http://localhost:8081/api/cartItems/
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCartItem(@PathVariable("id") Long cartItemId) {
        try {
            cartItemsService.deleteCartItem(cartItemId);
            return ResponseEntity.ok("CartItem successfully deleted!");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }
}
