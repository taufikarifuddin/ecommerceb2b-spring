package com.taufik.config;

import org.springframework.stereotype.Service;

import com.taufik.other.Constant;

@Service
public class MemberDetailService extends UserDetailService{
	public MemberDetailService() {
		setRole_id(Constant.USER_STATUS);
	}	
}
