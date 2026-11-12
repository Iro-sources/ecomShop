package com.ecommerce.shop.service;

import com.ecommerce.shop.model.Category;
import com.ecommerce.shop.payload.CategoryDTO;
import com.ecommerce.shop.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse getAllCategories();
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    String deleteCategory(Long category);
    Category updateCategory(Category category, Long categoryId);
}
