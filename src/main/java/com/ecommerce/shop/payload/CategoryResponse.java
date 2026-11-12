package com.ecommerce.shop.payload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
//This class represents a response containing multiple categories.
public class CategoryResponse {
    private List<CategoryDTO> content;
}
