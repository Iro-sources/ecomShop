package com.ecommerce.shop.repositories;
import com.ecommerce.shop.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

//Category tells Spring Data JPA which entity the repository manages.
//Long specifies the Java type of that entity's primary key.
//JpaRepository provides methods such as save(), findById(), findAll(), and deleteById().
//save(category) uses Spring Data JPA and the JPA persistence provider (Hibernate in your project) to perform the database operation.
//This is called abstraction: you use a high-level method without manually implementing the SQL.
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByCategoryName( String categoryName);
}
