package com.example.quanlynhasach.service;

import com.example.quanlynhasach.model.Compose;

import java.util.List;

public interface ComposeService {
    List<Compose> getAll();

    List<Compose> getByProductId(int productId);

    List<Compose> getByAuthorId(int authorId);

    Compose create(Compose compose);

    boolean delete(int productId, int authorId);
}
