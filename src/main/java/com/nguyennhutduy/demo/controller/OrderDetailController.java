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

import com.nguyennhutduy.demo.entity.OrderDetail;
import com.nguyennhutduy.demo.service.OrderDetailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/orderdetails")
@RequiredArgsConstructor
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    // Create OrderDetail
    // http://localhost:8081/api/orderdetails
    @PostMapping
    public ResponseEntity<?> createOrderDetail(@RequestBody OrderDetail orderDetail) {
        try {
            OrderDetail savedOrderDetail = orderDetailService.createOrderDetail(orderDetail);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedOrderDetail);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Create List OrderDetail
    // http://localhost:8081/api/orderdetails/list
    @PostMapping("/list")
    public ResponseEntity<?> createListOrderDetail(@RequestBody List<OrderDetail> orderDetail) {
        try {
            List<OrderDetail> savedOrderDetail = orderDetailService.createListOrderDetail(orderDetail);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedOrderDetail);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Get OrderDetail by ID
    // http://localhost:8081/api/orderdetails/{id}
    @GetMapping("{id}")
    public ResponseEntity<?> getOrderDetailById(@PathVariable("id") Long orderDetailId) {
        try {
            OrderDetail orderDetail = orderDetailService.getOrderDetailById(orderDetailId);
            return ResponseEntity.ok(orderDetail);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Get OrderDetail by OrderId
    // http://localhost:8081/api/orderdetails/order/{id}
    @GetMapping("/order/{id}")
    public ResponseEntity<List<OrderDetail>> getOrderDetailsByOrderId(@PathVariable("id") Long orderId) {
        List<OrderDetail> details = orderDetailService.getOrderDetailsByOrderId(orderId);
        return ResponseEntity.ok(details);
    }

    // Get All OrderDetails
    // http://localhost:8081/api/orderdetails/
    @GetMapping
    public ResponseEntity<?> getAllOrderDetail() {
        try {
            List<OrderDetail> orderDetails = orderDetailService.getAllOrderDetail();
            return ResponseEntity.ok(orderDetails);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Update OrderDetail
    // http://localhost:8081/api/orderdetails/{id}
    @PutMapping("{id}")
    public ResponseEntity<?> updateOrderDetail(@PathVariable("id") Long orderDetailId,
            @RequestBody OrderDetail orderDetail) {
        try {
            orderDetail.setId(orderDetailId);
            OrderDetail updatedOrderDetail = orderDetailService.updateOrderDetail(orderDetail);
            return ResponseEntity.ok(updatedOrderDetail);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Delete OrderDetail
    // http://localhost:8081/api/orderdetails/
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrderDetail(@PathVariable("id") Long orderDetailId) {
        try {
            orderDetailService.deleteOrderDetail(orderDetailId);
            return ResponseEntity.ok("OrderDetail successfully deleted!");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }
}
