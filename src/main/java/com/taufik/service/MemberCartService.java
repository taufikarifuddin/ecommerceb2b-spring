package com.taufik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.taufik.base.BaseResponse;
import com.taufik.base.BaseService;
import com.taufik.model.Member;
import com.taufik.model.MemberCart;
import com.taufik.other.Constant;
import com.taufik.repository.MemberCartRepository;
import com.taufik.repository.MemberRepository;

@Service
public class MemberCartService extends BaseService<MemberCart,MemberCartRepository>{

	@Autowired
	MemberRepository member;
	
	public static final String API_ROUTE = Constant.API_USER_PREFIX+"/cart";
	
	public BaseResponse findMemberCart(){
		BaseResponse response = this.setResponse();
		response.setErrorResponse(false);
		try{
			Member memberDetail = getMemberIdFromEmail(SecurityContextHolder.getContext().getAuthentication()
					.getName());			
			List<MemberCart> cart = this.repo.findByMemberId(memberDetail.getId());				
			response.setDataResponse(cart);				
		}catch (Exception e) {
			response.setErrorResponse(true);			
		}
		return response;		
	}
	
	@Override
	public BaseResponse save(MemberCart data) {
		if( data.getId() == 0 ){			
			Member member = getMemberIdFromEmail( SecurityContextHolder.getContext().getAuthentication().getName() );
			if( member == null )
				return this.setResponse();
			
			data.setMemberId( member.getId() );
		}
		return super.save(data);
	}

	public Member getMemberIdFromEmail(String email){
		return member.findByEmail(email);
	}
	
}
