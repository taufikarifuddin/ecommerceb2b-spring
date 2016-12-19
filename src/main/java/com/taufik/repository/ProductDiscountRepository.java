package com.taufik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taufik.model.ProductDiscount;

public interface ProductDiscountRepository extends JpaRepository<ProductDiscount, Integer>{

	public List<ProductDiscount> findByProductId(int id);
	
}
