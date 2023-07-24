package com.anapedra.commerce.repositories;

import com.anapedra.commerce.entities.Category;
import com.anapedra.commerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.categories cats WHERE " +
            "(COALESCE(:categories) IS NULL OR cats IN :categories ) AND " +
            "(LOWER(cats.description) LIKE LOWER(CONCAT('%',:categoryDescription,'%'))) AND "+
            "(LOWER(obj.shortDescription) LIKE LOWER(CONCAT('%',:productDescription,'%')))")
    Page<Product> find(List<Category> categories, String categoryDescription, String productDescription, Pageable pageable);
    @Query("SELECT obj FROM Product obj JOIN FETCH obj.categories WHERE obj IN :products ")
    List<Product> findProducts(List<Product> products);
}
