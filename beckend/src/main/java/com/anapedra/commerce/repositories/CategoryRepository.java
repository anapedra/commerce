package com.anapedra.commerce.repositories;

import com.anapedra.commerce.entities.Category;
import com.anapedra.commerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
