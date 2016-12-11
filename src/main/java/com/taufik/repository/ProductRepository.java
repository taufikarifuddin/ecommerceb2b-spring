package com.taufik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taufik.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
