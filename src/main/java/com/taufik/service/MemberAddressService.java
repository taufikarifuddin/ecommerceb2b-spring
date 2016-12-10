package com.taufik.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.taufik.base.BaseService;
import com.taufik.model.MemberAddress;

@Service
public class MemberAddressService extends BaseService<MemberAddress, JpaRepository<MemberAddress,Integer>>{

}
