package com.example.quanlynhasach.service;

import com.example.quanlynhasach.model.Category;
import java.util.List;

public interface CategoryService {
    List<Category> getAllCategorys();

    Category getCategoryById(int id);

    Category createCategory(Category category);

    Category updateCategory(int id, Category category);

    boolean deleteCategory(int id);
}