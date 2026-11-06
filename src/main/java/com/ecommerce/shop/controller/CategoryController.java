package com.ecommerce.shop.controller;
import com.ecommerce.shop.model.Category;
import com.ecommerce.shop.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
//Spring discovers it and uses its mapped methods to handle incoming HTTP requests.
//The methods return response data directly. For example, when the Controller returns a List<Category>,
// Spring can serialize it into JSON for the client.

public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/public/categories")
    public ResponseEntity<List<Category>> fetchAllCategories(){
        List<Category> categories = categoryService.getAllCategories(); //	Calls the service method
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    //@RequestBody tells Spring to convert the incoming JSON into a Category object.
    //Without @RequestBody, Spring MVC may treat the Category parameter as a model attribute,
    // binding request parameters instead of reading the JSON body in the usual way.
    //@Valid triggers validation of that object.
    //ResponseEntity<String> means the method returns an HTTP response containing a String body
    public ResponseEntity<String> addNewCategory(@Valid @RequestBody Category category){
        categoryService.createCategory(category); //	Calls the service method
        return new ResponseEntity<>("Category was added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
            String status = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category, @PathVariable Long categoryId){

            Category savedCategory = categoryService.updateCategory(category, categoryId);
            return new ResponseEntity<>("Updated category with category id: " + categoryId, HttpStatus.OK);
    }


}

