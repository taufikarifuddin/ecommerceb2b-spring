package com.taufik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taufik.model.MemberCart;

public interface MemberCartRepository extends JpaRepository<MemberCart, Integer>{
	
	public MemberCart findByProductIdAndMemberId(int productId,int memberId);
	public List<MemberCart> findByMemberId(int memberId);
	
}
