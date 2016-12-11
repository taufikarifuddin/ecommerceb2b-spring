package com.taufik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taufik.model.MemberAddress;

public interface MemberAddressRepository extends JpaRepository<MemberAddress, Integer>{

}
