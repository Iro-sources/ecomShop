package com.ecommerce.shop.payload;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
//This class represents the data of one category that I want to transfer between layers or send to the client
public class CategoryDTO {
    private Long categoryId;
    private String categoryName;
}
