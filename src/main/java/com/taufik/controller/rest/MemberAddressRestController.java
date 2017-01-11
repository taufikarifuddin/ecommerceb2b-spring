package com.taufik.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taufik.base.BaseResponse;
import com.taufik.base.BaseRestControllerInterface;
import com.taufik.model.MemberAddress;
import com.taufik.service.MemberAddressService;

@RestController
public class MemberAddressRestController implements BaseRestControllerInterface<MemberAddress>{

	@Autowired
	MemberAddressService service;
	
	@Override
	@PostMapping( MemberAddressService.API_ROUTE+"/update" )
	public BaseResponse update(MemberAddress data, BindingResult bindingResult) {

		if( bindingResult.hasErrors() ){
			return new BaseResponse(bindingResult.getAllErrors(), true);
		}
		
		return service.save(data);
	}

	@Override
	public BaseResponse delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResponse get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResponse getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
