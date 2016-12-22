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
import com.taufik.model.ProductImage;
import com.taufik.other.Constant;
import com.taufik.service.ProductImageService;

@RestController
public class ProductImageRestController {

	@Autowired
	private ProductImageService service;
	private final String controllerName = "productImage";
	
		
	@RequestMapping( value = Constant.API_PREFIX+controllerName+Constant.UPDATE_POSTFIX,method = RequestMethod.POST )	
	public BaseResponse update(@RequestBody @Valid ProductImage data,BindingResult bindingResult) {
		// TODO Auto-generated method stub		
		
		if( bindingResult.hasErrors() ){	
			return new BaseResponse(bindingResult.getAllErrors(),true);
		}
		BaseResponse response = service.save(data);
		response.setDataResponse(data);
		return response;
	}

	@RequestMapping( value = Constant.API_PREFIX+controllerName+Constant.REMOVE_POSTFIX,method = RequestMethod.POST )		
	public BaseResponse delete(int id) {
		// TODO Auto-generated method stub
		return service.remove(id);
	}

	@RequestMapping(value = Constant.API_PREFIX+controllerName+Constant.GET_ALL_POSTFIX)				
	public BaseResponse getAllByIdProduct(@RequestParam( defaultValue = "0",required = true ) int id) {
		// TODO Auto-generated method stub
		return service.getByIdProduct(id);
	}

}
