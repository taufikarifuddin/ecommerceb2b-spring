package com.taufik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taufik.model.MemberCart;

public interface MemberCartRepository extends JpaRepository<MemberCart, Integer>{

}
