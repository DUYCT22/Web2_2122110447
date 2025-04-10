package com.nguyennhutduy.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nguyennhutduy.demo.entity.OrderDetail;
import com.nguyennhutduy.demo.repository.OrderDetailRepository;
import com.nguyennhutduy.demo.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail getOrderDetailById(Long orderDetailId) {
        return orderDetailRepository.findById(
                orderDetailId)
                .orElseThrow(() -> new RuntimeException("OrderDetail with ID " + orderDetailId + " not found"));
    }

    @Override
    public List<OrderDetail> getAllOrderDetail() {
        return orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
        OrderDetail existingOrderDetail = orderDetailRepository.findById(orderDetail.getId())
                .orElseThrow(() -> new RuntimeException("OrderDetail not found"));
        if (orderDetail.getTotalAmount() != 0 && orderDetail.getTotalAmount() != existingOrderDetail.getTotalAmount()) {
            existingOrderDetail.setTotalAmount(orderDetail.getTotalAmount());
        }
        if (orderDetail.getQuantity() != 0 && orderDetail.getQuantity() != existingOrderDetail.getQuantity()) {
            existingOrderDetail.setQuantity(orderDetail.getQuantity());
        }
        return orderDetailRepository.save(existingOrderDetail);
    }

    @Override
    public void deleteOrderDetail(Long orderDetailId) {
        if (!orderDetailRepository.existsById(orderDetailId)) {
            throw new RuntimeException("OrderDetail with ID " + orderDetailId + " not found");
        }
        orderDetailRepository.deleteById(orderDetailId);
    }

}
