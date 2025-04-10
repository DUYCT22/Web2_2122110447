package com.nguyennhutduy.demo.service;

import java.util.List;

import com.nguyennhutduy.demo.entity.OrderDetail;

public interface OrderDetailService {
    OrderDetail createOrderDetail(OrderDetail orderDetail);

    OrderDetail getOrderDetailById(Long orderDetailId);

    List<OrderDetail> getAllOrderDetail();

    OrderDetail updateOrderDetail(OrderDetail orderDetail);

    void deleteOrderDetail(Long orderDetailId);
}
