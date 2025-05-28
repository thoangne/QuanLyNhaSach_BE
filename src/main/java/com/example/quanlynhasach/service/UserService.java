package com.example.quanlynhasach.service;

import com.example.quanlynhasach.model.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<User> getAllUsers();

    Optional<User> getUserById(UUID id); // Trả về Optional<User> để tránh lỗi null

    User createUser(User user);

    Optional<User> updateUser(UUID id, User user); // Trả về Optional<User> để kiểm tra cập nhật có thành công không

    boolean deleteUser(UUID id);
}