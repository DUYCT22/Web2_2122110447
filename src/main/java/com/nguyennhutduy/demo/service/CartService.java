package com.nguyennhutduy.demo.service;

import java.util.List;

import com.nguyennhutduy.demo.entity.Cart;

public interface CartService {
    Cart createCart(Cart cart);

    Cart getCartById(Long cartId);

    List<Cart> getAllCart();
}
