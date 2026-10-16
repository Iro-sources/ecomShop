package com.ecommerce.shop.service;
import com.ecommerce.shop.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    private Long nextCategoryId = 1L;
    private List<Category> categories = new ArrayList<>();


    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        //enabling dynamic id for the application
        category.setCategoryId(nextCategoryId);
        nextCategoryId ++;
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId){
        Category category = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst().orElse(null);

        if (category == null){
            return "Category not found";
        }
        categories.remove(category);
        return "Category with categoryId: " + categoryId + " was deleted successfully";
    }
}
