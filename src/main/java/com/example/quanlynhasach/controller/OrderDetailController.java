package com.example.quanlynhasach.controller;

import com.example.quanlynhasach.model.OrderDetail;
import com.example.quanlynhasach.model.OrderDetailId;
import com.example.quanlynhasach.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orderdetails")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping
    public ResponseEntity<List<OrderDetail>> getAllOrderDetails() {
        return ResponseEntity.ok(orderDetailService.getAllOrderDetails());
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderDetail>> getOrderDetailsByOrderId(@PathVariable int orderId) {
        return ResponseEntity.ok(orderDetailService.getOrderDetailsByOrderId(orderId));
    }

    // Vì khóa chính là composite key nên nhận 2 param riêng để tạo OrderDetailId
    @GetMapping("/{orderId}/{productId}")
    public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable int orderId, @PathVariable int productId) {
        OrderDetailId id = new OrderDetailId(orderId, productId);
        Optional<OrderDetail> orderDetailOpt = orderDetailService.getOrderDetailById(id);
        return orderDetailOpt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrderDetail> createOrderDetail(@RequestBody OrderDetail orderDetail) {
        OrderDetail created = orderDetailService.createOrderDetail(orderDetail);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{orderId}/{productId}")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable int orderId, @PathVariable int productId) {
        OrderDetailId id = new OrderDetailId(orderId, productId);
        orderDetailService.deleteOrderDetail(id);
        return ResponseEntity.noContent().build();
    }
}