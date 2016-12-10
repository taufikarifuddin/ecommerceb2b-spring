package com.taufik.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.taufik.base.BaseService;
import com.taufik.model.OrderComment;

@Service
public class OrderCommentService extends BaseService<OrderComment, JpaRepository<OrderComment,Integer>>{

}
