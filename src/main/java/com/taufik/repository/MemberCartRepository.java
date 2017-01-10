package com.taufik.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.taufik.model.MemberCart;

public interface MemberCartRepository extends JpaRepository<MemberCart, Integer>{
	
	public MemberCart findByProductIdAndMemberId(int productId,int memberId);
	
	public List<MemberCart> findByMemberId(int memberId);
	
	@Modifying
	@Transactional
	@Query("delete from MemberCart where memberId = ?1")
	void deleteAllUserCart(int idUser);
}
