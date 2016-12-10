package com.taufik.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.taufik.base.BaseService;
import com.taufik.model.ProductReview;

@Service
public class ProductReviewService extends BaseService<ProductReview, JpaRepository<ProductReview,Integer>>{

}
