package com.example.quanlynhasach.service;

import com.example.quanlynhasach.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(int id);

    Product createProduct(Product product);

    Product updateProduct(int id, Product product);

    boolean deleteProduct(int id);
}