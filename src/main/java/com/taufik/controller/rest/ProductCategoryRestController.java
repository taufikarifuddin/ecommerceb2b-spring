package com.taufik.controller.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taufik.base.BaseResponse;
import com.taufik.base.BaseRestControllerInterface;
import com.taufik.model.ProductCategory;
import com.taufik.other.Constant;
import com.taufik.service.ProductCategoryService;

@RestController
public class ProductCategoryRestController implements BaseRestControllerInterface<ProductCategory>{

	@Autowired
	ProductCategoryService service;
	
	@Override
	@RequestMapping( value = Constant.API_PREFIX+"productCategory"+Constant.UPDATE_POSTFIX,method = RequestMethod.POST )
	public BaseResponse update(@RequestBody @Valid ProductCategory data, 
			BindingResult bindingResult) {
		
		if( bindingResult.hasErrors() ){
			return new BaseResponse(bindingResult.getAllErrors(), true);
		}
		
		return service.save(data);
	}

	@Override
	@RequestMapping( value = Constant.API_PREFIX+"productCategory"+Constant.REMOVE_POSTFIX,method = RequestMethod.POST)		
	public BaseResponse delete( int id) {
		return service.remove(id);
	}

	@Override
	@RequestMapping( value = Constant.API_PREFIX+"productCategory"+Constant.GET_POSTFIX )	
	public BaseResponse get(int id) {
		// TODO Auto-generated method stub
		return service.getById(id);
	}

	@Override
	@RequestMapping( value = Constant.API_PREFIX+"productCategory"+Constant.GET_ALL_POSTFIX )
	public BaseResponse getAll() {		
		return service.getAll();
	}

}
