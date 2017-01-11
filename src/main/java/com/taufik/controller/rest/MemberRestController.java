package com.taufik.controller.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taufik.base.BaseResponse;
import com.taufik.base.BaseRestControllerInterface;
import com.taufik.model.Member;
import com.taufik.other.Constant;
import com.taufik.service.MemberService;

@RestController
public class MemberRestController implements BaseRestControllerInterface<Member>{

	@Autowired
	MemberService service;
	
	@Override
	@RequestMapping( value = Constant.API_PREFIX+MemberService.CONTROLLER_NAME+Constant.UPDATE_POSTFIX,method = RequestMethod.POST )	
	public BaseResponse update(@Valid @RequestBody Member data, BindingResult bindingResult) {
		
		if( bindingResult.hasErrors() ){
			return new BaseResponse(bindingResult.getAllErrors(), true);
		}
		
		return service.save(data);
	}

	@Override
	public BaseResponse delete(int id) {
		// TODO Auto-generated method stub
		return this.service.remove(id);
	}
	
	@RequestMapping( value = Constant.API_USER_PREFIX+MemberService.CONTROLLER_NAME+Constant.GET_POSTFIX,method = RequestMethod.POST )	
	public BaseResponse getDetail() {				
		return service.getByLoggedUser();
	}
	
	@Override
	public BaseResponse get(int id) {
		// TODO Auto-generated method stub
		return service.getById(id);
	}

	@Override
	public BaseResponse getAll() {
		// TODO Auto-generated method stub
		return service.getAll();
	}
	
	@RequestMapping( value = Constant.API_PREFIX+MemberService.CONTROLLER_NAME+"/checkUserEmail",method = RequestMethod.POST )
	public BaseResponse getByUsername(@RequestParam( defaultValue = "" ) String email){
		return service.checkEmail(email);
	}
}
