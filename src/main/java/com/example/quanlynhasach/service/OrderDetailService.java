package com.example.quanlynhasach.service;

import com.example.quanlynhasach.model.OrderDetail;
import com.example.quanlynhasach.model.OrderDetailId;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {

    List<OrderDetail> getAllOrderDetails();

    Optional<OrderDetail> getOrderDetailById(OrderDetailId id);

    List<OrderDetail> getOrderDetailsByOrderId(int orderId);

    OrderDetail createOrderDetail(OrderDetail orderDetail);

    void deleteOrderDetail(OrderDetailId id);
}