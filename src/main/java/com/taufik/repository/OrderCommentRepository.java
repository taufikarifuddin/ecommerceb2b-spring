package com.taufik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taufik.model.OrderComment;

public interface OrderCommentRepository extends JpaRepository<OrderComment, Integer>{

}
