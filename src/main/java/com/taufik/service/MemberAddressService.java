package com.taufik.service;

import org.springframework.stereotype.Service;

import com.taufik.base.BaseService;
import com.taufik.model.MemberAddress;
import com.taufik.other.Constant;
import com.taufik.repository.MemberAddressRepository;

@Service
public class MemberAddressService extends BaseService<MemberAddress, MemberAddressRepository>{

	public static final String API_ROUTE = Constant.API_USER_PREFIX+"/memberAddress";
	
}
