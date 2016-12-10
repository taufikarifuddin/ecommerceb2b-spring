package com.taufik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taufik.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{

}
