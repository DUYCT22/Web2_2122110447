package com.nguyennhutduy.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nguyennhutduy.demo.entity.CartItems;
import com.nguyennhutduy.demo.repository.CartItemsRepository;
import com.nguyennhutduy.demo.service.CartItemsService;

@Service
public class CartItemsServiceImpl implements CartItemsService {

    private final CartItemsRepository cartItemsRepository;

    public CartItemsServiceImpl(CartItemsRepository cartItemsRepository) {
        this.cartItemsRepository = cartItemsRepository;
    }

    @Override
    public CartItems createCartItem(CartItems cartItem) {
        return cartItemsRepository.save(cartItem);
    }

    @Override
    public CartItems getCartItemById(Long cartItemId) {
        return cartItemsRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("CartItem with ID " + cartItemId + " not found"));
    }

    @Override
    public List<CartItems> getAllCartItems() {
        return cartItemsRepository.findAll();
    }

    @Override
    public CartItems updateCartItem(CartItems cartItem) {
        CartItems existingCartItem = cartItemsRepository.findById(cartItem.getId())
                .orElseThrow(() -> new RuntimeException("CartItem not found"));

        int newQuantity = cartItem.getQuantity();

        if (newQuantity != 0 && newQuantity != existingCartItem.getQuantity()) {
            existingCartItem.setQuantity(newQuantity);
        }

        return cartItemsRepository.save(existingCartItem);
    }

    @Override
    public void deleteCartItem(Long cartItemId) {
        if (!cartItemsRepository.existsById(cartItemId)) {
            throw new RuntimeException("CartItem with ID " + cartItemId + " not found");
        }
        cartItemsRepository.deleteById(cartItemId);
    }

}
