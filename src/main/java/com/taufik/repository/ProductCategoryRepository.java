package com.taufik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taufik.model.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>{

}
