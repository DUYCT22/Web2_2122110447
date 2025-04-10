package com.nguyennhutduy.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nguyennhutduy.demo.entity.Order;
import com.nguyennhutduy.demo.repository.OrderRepository;
import com.nguyennhutduy.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(
                orderId)
                .orElseThrow(() -> new RuntimeException("Order with ID " + orderId + " not found"));
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Order order) {
        Order existingOrder = orderRepository.findById(order.getId())
                .orElseThrow(() -> new RuntimeException("Order not found"));
        if (order.getTotalAmount() != 0 && order.getTotalAmount() != existingOrder.getTotalAmount()) {
            existingOrder.setTotalAmount(order.getTotalAmount());
        }
        if (order.getStatus() != 0 && order.getStatus() != existingOrder.getStatus()) {
            existingOrder.setStatus(order.getStatus());
        }
        return orderRepository.save(existingOrder);
    }

    @Override
    public void deleteOrder(Long orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new RuntimeException("Order with ID " + orderId + " not found");
        }
        orderRepository.deleteById(orderId);
    }

}
