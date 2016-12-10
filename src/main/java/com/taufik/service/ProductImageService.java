package com.taufik.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.taufik.base.BaseService;
import com.taufik.model.ProductImage;

@Service
public class ProductImageService extends BaseService<ProductImage, JpaRepository<ProductImage,Integer>>{

}
