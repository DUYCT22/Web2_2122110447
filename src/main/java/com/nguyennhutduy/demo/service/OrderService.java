package com.nguyennhutduy.demo.service;

import java.util.List;

import com.nguyennhutduy.demo.entity.Order;

public interface OrderService {
    Order createOrder(Order order);

    Order getOrderById(Long orderId);

    List<Order> getAllOrder();

    Order updateOrder(Order order);

    void deleteOrder(Long orderId);
}
