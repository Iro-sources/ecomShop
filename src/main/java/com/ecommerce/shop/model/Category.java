package com.ecommerce.shop.model;
/*
This is the model class of the category. It defines the structure of the category
of the shop application. Is responsible for representing a category and not managing a collection of categories.
 */
public class Category {
    private Long categoryId;
    private String categoryName;

    //Constructor initializes a new category object
    public Category(Long categoryId, String categoryName){
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    //Getter allows other classes to read the category ID
    public Long getCategoryId(){
        return categoryId;
    }
    //The setter allows the category ID to be changed
    public void setCategoryId(Long categoryId){
        this.categoryId = categoryId; //refers to the object field
    }

    public String getCategoryName(){
        return categoryName;
    }
    public void setCategoryName(String categoryName){
        this.categoryName = categoryName;
    }
}
