package com.example.quanlynhasach.service.impl;

import com.example.quanlynhasach.dto.CategoryDTO;
import com.example.quanlynhasach.dto.ProductDTO;
import com.example.quanlynhasach.dto.PublisherDTO;
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
            if (product.getStock() >= 0) {
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

    @Override
    public ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setSlug(product.getSlug());
        dto.setPrice(product.getPrice());
        dto.setDiscount(product.getDiscount());
        dto.setStock(product.getStock());
        dto.setDescription(product.getDescription());
        dto.setCoverImage(product.getCoverImage());

        if (product.getCategory() != null) {
            dto.setCategoryId(product.getCategory().getId());
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(product.getCategory().getId());
            categoryDTO.setName(product.getCategory().getName());
            categoryDTO.setDescription(product.getCategory().getDescription());
            dto.setCategory(categoryDTO);
        } else {
            dto.setCategoryId(null);
            dto.setCategory(null);
        }

        if (product.getPublisher() != null) {
            dto.setPublisherId(product.getPublisher().getId());
            PublisherDTO publisherDTO = new PublisherDTO();
            publisherDTO.setId(product.getPublisher().getId());
            publisherDTO.setName(product.getPublisher().getName());
            publisherDTO.setAddress(product.getPublisher().getAddress());
            publisherDTO.setContact(product.getPublisher().getContact());
            dto.setPublisher(publisherDTO);
        } else {
            dto.setPublisherId(null);
            dto.setPublisher(null);
        }

        return dto;
    }

}