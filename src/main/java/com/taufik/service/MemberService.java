package com.taufik.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.taufik.base.BaseResponse;
import com.taufik.base.BaseService;
import com.taufik.model.Member;
import com.taufik.repository.MemberRepository;


@Service
public class MemberService extends BaseService<Member,MemberRepository>{
	
	public static final String CONTROLLER_NAME = "member";
	
	public BaseResponse checkEmail(String email){
		BaseResponse response = setResponse();
		if( email != "" ){
			try{
				Member member = this.repo.findByEmail(email);
//				ketika user ebih dari 0 maka akan return value true yang artinya email masih belum digunakan
				response.setDataResponse( member == null );
			}catch (Exception e) {
				return response;
			}
		}
		return response;
	}
	
	public BaseResponse getByLoggedUser(){
		BaseResponse response = this.setResponse();
		
		try{
			String email = SecurityContextHolder.getContext().getAuthentication().getName();
			if( email != null ){
				Member member = this.repo.findByEmail(email);
				response.setErrorResponse(false);
				response.setDataResponse(member);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}		
		return response;
	}
	
}
