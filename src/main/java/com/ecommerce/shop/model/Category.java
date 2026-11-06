package com.ecommerce.shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
This is the model class of the category. It defines the structure of the category
of the shop application. Is responsible for representing a category and not managing a collection of categories.
 */
@Entity(name = "categories")
//Here I am adding Lombok annotations and using them so, that it is not needed extra constructors and getters/setters
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @NotBlank
    @Size(min = 5, message = "Category character must contain at least 5 characters")
    private String categoryName;

    //Constructor initializes a new category object
//    public Category(Long categoryId, String categoryName){
//        this.categoryId = categoryId;
//        this.categoryName = categoryName;
//    }

//    public Category() {
//    }

    //Getter allows other classes to read the category ID
//    public Long getCategoryId(){
//        return categoryId;
//    }
    //The setter allows the category ID to be changed
   // public void setCategoryId(Long categoryId){
      //  this.categoryId = categoryId; //refers to the object field
 //   }

//    public String getCategoryName(){
//        return categoryName;
//    }
//    public void setCategoryName(String categoryName){
//        this.categoryName = categoryName;
//    }

}
