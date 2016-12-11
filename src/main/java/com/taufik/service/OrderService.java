package com.taufik.service;

import org.springframework.stereotype.Service;

import com.taufik.base.BaseService;
import com.taufik.model.Order;
import com.taufik.repository.OrderRepository;


@Service
public class OrderService extends BaseService<Order,OrderRepository>{

}
