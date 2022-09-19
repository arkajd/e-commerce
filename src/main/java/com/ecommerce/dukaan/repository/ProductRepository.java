package com.ecommerce.dukaan.repository;

import com.ecommerce.dukaan.enums.Category;
import com.ecommerce.dukaan.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Collection<Product> findByCategory(Category category);
}
