package com.ecommerce.shop.service;
import com.ecommerce.shop.model.Category;
import com.ecommerce.shop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service //identifies a class that provides application business logic. It does not make its methods HTTP endpoints.
public class CategoryServiceImpl implements CategoryService{
    private Long nextCategoryId = 1L;
    //List is a java interface
    //private List<Category> categories = new ArrayList<>();//ArrayList is a java class that implements
    //This is called programming to an interface rather than an implementation.

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        //return categories;
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        //enabling dynamic id for the application
       // category.setCategoryId(nextCategoryId ++);
        //categories.add(category);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId){
        //We need to create a list of local variable in order to use the categories saved in  category repository
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));

        //categories.remove(category);
        categoryRepository.delete(category);
        return "Category with categoryId: " + categoryId + " was deleted successfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {

        Category savedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));

        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return savedCategory;

    }
}
