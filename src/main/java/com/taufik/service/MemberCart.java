package com.taufik.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.taufik.base.BaseService;

@Service
public class MemberCart extends BaseService<MemberCart, JpaRepository<MemberCart,Integer>>{

}
