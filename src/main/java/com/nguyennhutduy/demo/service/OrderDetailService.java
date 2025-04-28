package com.nguyennhutduy.demo.service;

import java.util.List;

import com.nguyennhutduy.demo.entity.OrderDetail;

public interface OrderDetailService {
    OrderDetail createOrderDetail(OrderDetail orderDetail);

    List<OrderDetail> createListOrderDetail(List<OrderDetail> orderDetail);

    OrderDetail getOrderDetailById(Long orderDetailId);

    List<OrderDetail> getOrderDetailsByOrderId(Long orderId);

    List<OrderDetail> getAllOrderDetail();

    OrderDetail updateOrderDetail(OrderDetail orderDetail);

    void deleteOrderDetail(Long orderDetailId);
}
