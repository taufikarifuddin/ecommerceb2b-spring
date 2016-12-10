package com.taufik.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.taufik.base.BaseService;
import com.taufik.model.ProductDiscount;

@Service
public class ProductDiscountService extends BaseService<ProductDiscount, JpaRepository<ProductDiscount,Integer>>{

}
