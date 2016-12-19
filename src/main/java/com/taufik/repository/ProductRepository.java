package com.taufik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taufik.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	public List<Product> findByCode(String code);
	
}
