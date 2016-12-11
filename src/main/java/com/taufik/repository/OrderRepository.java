package com.taufik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taufik.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
