package com.taufik.config;


import com.taufik.other.Constant;

public class MemberDetailService extends UserDetailService{
	public MemberDetailService() {
		setRole_id(Constant.USER_STATUS);
	}	
}
