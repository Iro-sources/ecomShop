package com.ecommerce.shop.service;

import com.ecommerce.shop.model.Category;
import com.ecommerce.shop.payload.CategoryDTO;
import com.ecommerce.shop.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse getAllCategories();
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO deleteCategory(Long category);
    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
