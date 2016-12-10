package com.taufik.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.taufik.base.BaseService;
import com.taufik.model.ProductCategory;

@Service
public class ProductCategoryService extends BaseService<ProductCategory, JpaRepository<ProductCategory,Integer>>{

}
