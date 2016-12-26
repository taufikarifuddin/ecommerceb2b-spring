package com.taufik.config;

import com.taufik.other.Constant;

public class AdminDetailService extends UserDetailService{

	public AdminDetailService() {
		setRole_id(Constant.ADMIN_STATUS);
	}
	
}
