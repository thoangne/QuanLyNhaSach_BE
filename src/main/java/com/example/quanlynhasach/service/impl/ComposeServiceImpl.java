package com.example.quanlynhasach.service.impl;

import com.example.quanlynhasach.model.Compose;
import com.example.quanlynhasach.model.ComposeId;
import com.example.quanlynhasach.repository.ComposeRepository;
import com.example.quanlynhasach.service.ComposeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComposeServiceImpl implements ComposeService {

    private final ComposeRepository composeRepository;

    @Autowired
    public ComposeServiceImpl(ComposeRepository composeRepository) {
        this.composeRepository = composeRepository;
    }

    @Override
    public List<Compose> getAll() {
        return composeRepository.findAll();
    }

    @Override
    public List<Compose> getByProductId(int productId) {
        return composeRepository.findByProductId(productId);
    }

    @Override
    public List<Compose> getByAuthorId(int authorId) {
        return composeRepository.findByAuthorId(authorId);
    }

    @Override
    public Compose create(Compose compose) {
        return composeRepository.save(compose);
    }

    @Override
    public boolean delete(int productId, int authorId) {
        ComposeId id = new ComposeId(productId, authorId);
        if (composeRepository.existsById(id)) {
            composeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}