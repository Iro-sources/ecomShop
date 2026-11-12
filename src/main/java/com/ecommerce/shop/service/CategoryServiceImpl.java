package com.ecommerce.shop.service;
import com.ecommerce.shop.exceptions.ApiException;
import com.ecommerce.shop.exceptions.ResourceNotFoundException;
import com.ecommerce.shop.model.Category;
import com.ecommerce.shop.payload.CategoryDTO;
import com.ecommerce.shop.payload.CategoryResponse;
import com.ecommerce.shop.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //identifies a class that provides application business logic. It does not make its methods HTTP endpoints.
public class CategoryServiceImpl implements CategoryService{
    //after connected to the database we don't need this "  private Long nextCategoryId = 1L;"
    //coz we are generating ids in a database level

    //List is a java interface
    //private List<Category> categories = new ArrayList<>();//ArrayList is a java class that implements
    //This is called programming to an interface rather than an implementation.

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryResponse getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty())
            throw new ApiException("Sorry, there are no categories in the system");

        List<CategoryDTO> categoryDTOS = categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                //.collect(Collectors.toList());
                .toList();

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);
        //return categories;
        return categoryResponse;

    }

    @Override
    public CategoryDTO createCategory(CategoryDTO  categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        Category categoryFromDb = categoryRepository.findByCategoryName(category.getCategoryName());
        if (categoryFromDb != null)
            throw new ApiException("Category with the name " + category.getCategoryName() + " already exists");
        category.setCategoryId(null);
        Category savedCategory = categoryRepository.save(category);
        CategoryDTO savedCategoryDTO;
        savedCategoryDTO = modelMapper.map(savedCategory, CategoryDTO.class);
        return savedCategoryDTO;
    }

    @Override
    public String deleteCategory(Long categoryId){
        //We need to create a list of local variable in order to use the categories saved in  category repository
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        //categories.remove(category);
        categoryRepository.delete(category);
        return "Category with categoryId: " + categoryId + " was deleted successfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {

        Category savedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return savedCategory;

    }
}
