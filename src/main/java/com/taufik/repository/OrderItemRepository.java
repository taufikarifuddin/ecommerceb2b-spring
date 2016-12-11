package com.taufik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taufik.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

}
