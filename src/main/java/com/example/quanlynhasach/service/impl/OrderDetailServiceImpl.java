package com.example.quanlynhasach.service.impl;

import com.example.quanlynhasach.model.OrderDetail;
import com.example.quanlynhasach.model.OrderDetailId;
import com.example.quanlynhasach.repository.OrderDetailRepository;
import com.example.quanlynhasach.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    @Override
    public Optional<OrderDetail> getOrderDetailById(OrderDetailId id) {
        return orderDetailRepository.findById(id);
    }

    @Override
    public List<OrderDetail> getOrderDetailsByOrderId(int orderId) {
        return orderDetailRepository.findByOrderId(orderId);
    }

    @Override
    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        if (orderDetail.getOrder() == null || orderDetail.getProduct() == null) {
            throw new IllegalArgumentException("Order and Product must not be null");
        }

        if (orderDetail.getOrder().getId() == 0 || orderDetail.getProduct().getId() == 0) {
            throw new IllegalArgumentException("Order ID and Product ID must not be 0");
        }

        OrderDetailId id = new OrderDetailId(
                orderDetail.getOrder().getId(),
                orderDetail.getProduct().getId());
        orderDetail.setId(id);
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public void deleteOrderDetail(OrderDetailId id) {
        orderDetailRepository.deleteById(id);
    }
}