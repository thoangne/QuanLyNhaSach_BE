package com.example.quanlynhasach.repository;

import com.example.quanlynhasach.model.OrderDetail;
import com.example.quanlynhasach.model.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {

    List<OrderDetail> findByOrderId(int orderId);

    List<OrderDetail> findByProductId(int productId);
}