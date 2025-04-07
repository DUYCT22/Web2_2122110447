package com.nguyennhutduy.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyennhutduy.demo.entity.CartItems;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, Long> {

}
