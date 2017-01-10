package com.taufik.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taufik.base.BaseResponse;
import com.taufik.base.BaseRestControllerInterface;
import com.taufik.model.Order;
import com.taufik.service.OrderService;

@RestController
public class OrderRestController implements BaseRestControllerInterface<Order>{

	@Autowired
	OrderService service;
	
	@PostMapping( OrderService.API_ROUTE+"/checkout" )	
	@Override
	public BaseResponse update(@RequestBody Order data, BindingResult bindingResult) {
		// TODO Auto-generated method stub
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
