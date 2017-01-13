package com.taufik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taufik.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

	public List<Order> findByMemberId(int memberId);
	
}
