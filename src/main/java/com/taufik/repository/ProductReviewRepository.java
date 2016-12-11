package com.taufik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taufik.model.ProductReview;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Integer> {

}
