package com.taufik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taufik.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{
	
	public Member findByEmailAndRoleId(String email,int id);

	public Member findByEmailAndPassword(String email,String password);
	
	public Member findByEmail(String email);
}
