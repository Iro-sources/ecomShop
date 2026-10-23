package com.ecommerce.shop.service;

import com.ecommerce.shop.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();
    void createCategory(Category category);
    String deleteCategory(Long category);
    Category updateCategory(Category category, Long categoryId);
}
