package com.taufik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taufik.model.ProductImage;

public interface ProductImageRespository extends JpaRepository<ProductImage, Integer>{

	public List<ProductImage> findByProductId(int id);
	
}
