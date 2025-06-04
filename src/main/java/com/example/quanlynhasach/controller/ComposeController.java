package com.example.quanlynhasach.controller;

import com.example.quanlynhasach.model.Compose;
import com.example.quanlynhasach.service.ComposeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compose")
public class ComposeController {

    private final ComposeService composeService;

    @Autowired
    public ComposeController(ComposeService composeService) {
        this.composeService = composeService;
    }

    @GetMapping
    public ResponseEntity<List<Compose>> getAll() {
        return ResponseEntity.ok(composeService.getAll());
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Compose>> getByProduct(@PathVariable int productId) {
        return ResponseEntity.ok(composeService.getByProductId(productId));
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<Compose>> getByAuthor(@PathVariable int authorId) {
        return ResponseEntity.ok(composeService.getByAuthorId(authorId));
    }

    @PostMapping
    public ResponseEntity<Compose> create(@RequestBody Compose compose) {
        Compose created = composeService.create(compose);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam int productId, @RequestParam int authorId) {
        boolean deleted = composeService.delete(productId, authorId);
        if (deleted) {
            return ResponseEntity.ok("Xóa thành công.");
        } else {
            return ResponseEntity.status(404).body("Không tìm thấy bản ghi.");
        }
    }
}