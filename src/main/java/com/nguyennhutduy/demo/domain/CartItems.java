package com.nguyennhutduy.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CartItems")
public class CartItems {

    @Column(nullable = false, unique = false)
    private int cartId;

    @Column(nullable = false, unique = false)
    private int productId;

    @Column(nullable = false, unique = false)
    private int quantity;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
