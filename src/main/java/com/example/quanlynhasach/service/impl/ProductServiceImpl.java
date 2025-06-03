package com.example.quanlynhasach.service.impl;

import com.example.quanlynhasach.model.Product;
import com.example.quanlynhasach.repository.ProductRepository;
import com.example.quanlynhasach.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        return productRepository.findById(id).map(existingProduct -> {
            if (product.getTitle() != null) {
                existingProduct.setTitle(product.getTitle());
            }
            if (product.getSlug() != null) {
                existingProduct.setSlug(product.getSlug());
            }
            if (product.getPrice() != null) {
                existingProduct.setPrice(product.getPrice());
            }
            if (product.getDiscount() != null) {
                existingProduct.setDiscount(product.getDiscount());
            }
            if (product.getStock() != null) {
                existingProduct.setStock(product.getStock());
            }
            if (product.getDescription() != null) {
                existingProduct.setDescription(product.getDescription());
            }
            if (product.getCoverImage() != null) {
                existingProduct.setCoverImage(product.getCoverImage());
            }
            return productRepository.save(existingProduct);
        }).orElse(null);
    }

    @Override
    public boolean deleteProduct(int id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}