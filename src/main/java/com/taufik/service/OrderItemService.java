package com.taufik.service;

import org.springframework.stereotype.Service;

import com.taufik.base.BaseService;
import com.taufik.model.OrderItem;
import com.taufik.repository.OrderItemRepository;

@Service
public class OrderItemService extends BaseService<OrderItem, OrderItemRepository>{

}
