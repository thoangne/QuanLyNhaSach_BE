package com.example.quanlynhasach.repository;

import com.example.quanlynhasach.model.Compose;
import com.example.quanlynhasach.model.ComposeId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComposeRepository extends JpaRepository<Compose, ComposeId> {
    List<Compose> findByProductId(int productId);

    List<Compose> findByAuthorId(int authorId);
}