package com.nguyennhutduy.demo.service;

import java.util.List;

import com.nguyennhutduy.demo.entity.CartItems;

public interface CartItemsService {
    CartItems createCartItem(CartItems cartItem);

    CartItems getCartItemById(Long cartItemId);

    List<CartItems> getAllCartItems();

    CartItems updateCartItem(CartItems cartItem);

    void deleteCartItem(Long cartItemId);
}
