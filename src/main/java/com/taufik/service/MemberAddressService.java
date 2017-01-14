package com.taufik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.taufik.base.BaseResponse;
import com.taufik.base.BaseService;
import com.taufik.model.Member;
import com.taufik.model.MemberAddress;
import com.taufik.other.Constant;
import com.taufik.repository.MemberAddressRepository;
import com.taufik.repository.MemberRepository;

@Service
public class MemberAddressService extends BaseService<MemberAddress, MemberAddressRepository>{
	@Autowired
	MemberRepository memberRepo;
	
	public static final String API_ROUTE = Constant.API_USER_PREFIX+"/memberAddress";
	
	@Override
	public BaseResponse save(MemberAddress data) {
		if( data.getId() == 0  ){
			Member member = memberRepo.findByEmail(
					SecurityContextHolder.getContext().getAuthentication()
					.getName());			
			if( member == null ){
				return this.setResponse();
			}else{
				data.setMemberId(member.getId());
			}
			
		}
		
		return super.save(data);
	}
	
	
	
	
}
