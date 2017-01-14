package com.taufik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.taufik.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	public List<Product> findByCode(String code);

	@Query("select p from Product p where p.categoryId = ?1 and p.name "
			+ "like %?2% and p.isVisible = 1")
	public List<Product> getSearch(int categoryId,String name);
	
	@Query("select p from Product p where p.name like %?1% and p.isVisible = 1")
	public List<Product> getSearch(String name);	
}
