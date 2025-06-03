package com.example.quanlynhasach.controller;

import com.example.quanlynhasach.model.Payment;
import com.example.quanlynhasach.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<?> getAllPayments() {
        try {
            List<Payment> payments = paymentService.getAllPayments();
            return ResponseEntity.ok(payments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi khi lấy danh sách thanh toán: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPaymentById(@PathVariable int id) {
        try {
            Payment payment = paymentService.getPaymentById(id);
            if (payment != null) {
                return ResponseEntity.ok(payment);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Không tìm thấy thanh toán với ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi khi lấy thông tin thanh toán: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createPayment(@RequestBody Payment payment) {
        try {
            Payment newPayment = paymentService.createPayment(payment);
            return ResponseEntity.status(HttpStatus.CREATED).body(newPayment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi khi tạo thanh toán: " + e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePayment(@PathVariable int id, @RequestBody Payment payment) {
        try {
            Payment updated = paymentService.updatePayment(id, payment);
            if (updated != null) {
                return ResponseEntity.ok(updated);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Không tìm thấy thanh toán để cập nhật với ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi khi cập nhật thanh toán: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePayment(@PathVariable int id) {
        try {
            boolean deleted = paymentService.deletePayment(id);
            if (deleted) {
                return ResponseEntity.ok("Đã xóa hóa đơn có ID = " + id);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Không tìm thấy thanh toán để xóa với ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi khi xóa thanh toán: " + e.getMessage());
        }
    }
}