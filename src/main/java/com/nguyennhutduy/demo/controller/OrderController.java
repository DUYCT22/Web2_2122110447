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

import com.nguyennhutduy.demo.entity.Order;
import com.nguyennhutduy.demo.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    // Create Order
    // http://localhost:8081/api/orders
    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        try {
            Order savedOrder = orderService.createOrder(order);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Get Order by ID
    // http://localhost:8081/api/orders/{id}
    @GetMapping("{id}")
    public ResponseEntity<?> getOrderById(@PathVariable("id") Long orderId) {
        try {
            Order order = orderService.getOrderById(orderId);
            return ResponseEntity.ok(order);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Get All Orders
    // http://localhost:8081/api/orders/
    @GetMapping
    public ResponseEntity<?> getAllOrder() {
        try {
            List<Order> orders = orderService.getAllOrder();
            return ResponseEntity.ok(orders);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Update Order
    // http://localhost:8081/api/orders/{id}
    @PutMapping("{id}")
    public ResponseEntity<?> updateOrder(@PathVariable("id") Long orderId,
            @RequestBody Order order) {
        try {
            order.setId(orderId);
            Order updatedOrder = orderService.updateOrder(order);
            return ResponseEntity.ok(updatedOrder);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Delete Order
    // http://localhost:8081/api/orders/
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long orderId) {
        try {
            orderService.deleteOrder(orderId);
            return ResponseEntity.ok("Order successfully deleted!");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }
}
