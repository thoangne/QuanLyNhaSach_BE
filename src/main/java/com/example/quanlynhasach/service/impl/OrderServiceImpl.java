package com.example.quanlynhasach.service.impl;

import com.example.quanlynhasach.model.Order;
import com.example.quanlynhasach.model.User;
import com.example.quanlynhasach.repository.OrderRepository;
import com.example.quanlynhasach.repository.UserRepository;
import com.example.quanlynhasach.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public Order createOrder(Order order) {
        int userId = order.getUser().getId();
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found with id: " + userId);
        }
        order.setUser(userOpt.get());
        return orderRepository.save(order);
    }

    @Override
    public boolean deleteOrder(int id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}