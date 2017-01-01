package com.taufik.controller.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taufik.base.BaseResponse;
import com.taufik.model.MemberCart;
import com.taufik.service.MemberCartService;

@RestController
public class CartRestController{
	
	@Autowired
	MemberCartService service;
	
	@PostMapping( MemberCartService.API_ROUTE+"/update" )	
	public BaseResponse update(@Valid @RequestBody MemberCart data, BindingResult bindingResult) {
		// TODO Auto-generated method stub
		return service.save(data);
	}

	@PostMapping( MemberCartService.API_ROUTE+"/remove" )	
	public BaseResponse delete(@RequestParam( defaultValue = "0",name = "id" ) int id) {
		// TODO Auto-generated method stub
		return service.remove(id);
	}

	@GetMapping( MemberCartService.API_ROUTE+"/getAll" )	
	public BaseResponse getAll() {
		return service.findMemberCart();
	}	

}
