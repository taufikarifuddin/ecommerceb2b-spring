package com.taufik.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taufik.base.BaseResponse;
import com.taufik.base.BaseRestControllerInterface;
import com.taufik.model.Order;
import com.taufik.other.Constant;
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
	@RequestMapping( value = Constant.API_PREFIX+"order"+Constant.GET_POSTFIX )	
	public BaseResponse get(int id) {
		// TODO Auto-generated method stub
		return service.getById(id);
	}

	@Override
	@RequestMapping( value = Constant.API_PREFIX+"order"+Constant.GET_ALL_POSTFIX )	
	public BaseResponse getAll() {
		// TODO Auto-generated method stub
		return service.getAll();
	}
	
	@RequestMapping( method = RequestMethod.POST, 
			value = Constant.API_PREFIX +"order"+Constant.UPDATE_POSTFIX)	
	public BaseResponse update(@RequestBody Order data){		
		return service.changeDataOrder(data);
	}
}
