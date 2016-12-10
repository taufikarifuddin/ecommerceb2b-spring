package com.taufik.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.taufik.base.BaseService;
import com.taufik.model.OrderItem;

@Service
public class OrderItemService extends BaseService<OrderItem, JpaRepository<OrderItem,Integer>>{

}
