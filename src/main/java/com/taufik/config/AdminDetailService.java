package com.taufik.config;

import org.springframework.stereotype.Service;

import com.taufik.other.Constant;

@Service
public class AdminDetailService extends UserDetailService{

	public AdminDetailService() {
		setRole_id(Constant.ADMIN_STATUS);
	}
	
}
