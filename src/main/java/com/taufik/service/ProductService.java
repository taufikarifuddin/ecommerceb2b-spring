package com.taufik.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.taufik.base.BaseService;
import com.taufik.model.Product;

@Service
public class ProductService extends BaseService<Product, JpaRepository<Product,Integer>>{

}
