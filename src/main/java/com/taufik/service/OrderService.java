package com.taufik.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.taufik.base.BaseService;
import com.taufik.model.Order;

@Service
public class OrderService extends BaseService<Order, JpaRepository<Order,Integer>>{

}
