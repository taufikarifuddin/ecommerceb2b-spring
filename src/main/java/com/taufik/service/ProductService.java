package com.taufik.service;

import org.springframework.stereotype.Service;

import com.taufik.base.BaseService;
import com.taufik.model.Product;
import com.taufik.repository.ProductRepository;

@Service
public class ProductService extends BaseService<Product, ProductRepository>{

}
