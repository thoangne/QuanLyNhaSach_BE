package com.example.quanlynhasach.controller;

import com.example.quanlynhasach.model.Publisher;
import com.example.quanlynhasach.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    // Lấy tất cả publisher
    @GetMapping
    public ResponseEntity<List<Publisher>> getAllPublishers() {
        try {
            List<Publisher> publishers = publisherService.getAllPublishers();
            return ResponseEntity.ok(publishers);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Lấy publisher theo id
    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable int id) {
        try {
            Publisher publisher = publisherService.getPublisherById(id);
            if (publisher != null) {
                return ResponseEntity.ok(publisher);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Tạo publisher mới
    @PostMapping
    public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher) {
        try {
            Publisher created = publisherService.createPublisher(publisher);
            return ResponseEntity.status(201).body(created);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Cập nhật publisher
    @PatchMapping("/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable int id, @RequestBody Publisher publisher) {
        try {
            Publisher updatedPublisher = publisherService.updatePublisher(id, publisher);
            if (updatedPublisher != null) {
                return ResponseEntity.ok(updatedPublisher);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Xóa publisher
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePublisher(@PathVariable int id) {
        try {
            boolean deleted = publisherService.deletePublisher(id);
            if (deleted) {
                return ResponseEntity.ok("Đã xóa Nhà xuất bản có ID = " + id);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}