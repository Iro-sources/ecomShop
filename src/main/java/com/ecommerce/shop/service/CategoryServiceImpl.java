package com.ecommerce.shop.service;
import com.ecommerce.shop.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service //identifies a class that provides application business logic. It does not make its methods HTTP endpoints.
public class CategoryServiceImpl implements CategoryService{
    private Long nextCategoryId = 1L;
    //List is a java interface
    private List<Category> categories = new ArrayList<>();//ArrayList is a java class that implements
    //This is called programming to an interface rather than an implementation.

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
        //creates a stream of existing categories list, which allows us to process its elements
        Category category = categories.stream()
                //defines a condition that determines which categories should pass through the stream
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));
        if (category == null){
            return "Category not found";
        }
        categories.remove(category);
        return "Category with categoryId: " + categoryId + " was deleted successfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Optional<Category> optionalCategory = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst();

        if (optionalCategory.isPresent()){
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            return existingCategory;
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
        }
    }
}
