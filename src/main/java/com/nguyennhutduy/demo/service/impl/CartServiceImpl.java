package com.nguyennhutduy.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nguyennhutduy.demo.entity.Cart;
import com.nguyennhutduy.demo.repository.CartRepository;
import com.nguyennhutduy.demo.service.CartService;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCartById(Long cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart with ID " + cartId + " not found"));
    }

    @Override
    public List<Cart> getAllCart() {
        return cartRepository.findAll();
    }

}
