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
import com.taufik.model.Product;
import com.taufik.other.Constant;
import com.taufik.service.ProductService;

@RestController
public class ProductRestController implements BaseRestControllerInterface<Product>{

	@Autowired
	private ProductService service;
	private final String controllerName = "product";
	
	@Override
	@RequestMapping( value = Constant.API_PREFIX+controllerName+Constant.UPDATE_POSTFIX,method = RequestMethod.POST )	
	public BaseResponse update(@RequestBody @Valid Product data, BindingResult bindingResult) {
		// TODO Auto-generated method stub
		if( bindingResult.hasErrors() ){
			return new BaseResponse(bindingResult.getAllErrors(),true);
		}
		return service.save(data);
	}

	@Override
	@RequestMapping( value = Constant.API_PREFIX+controllerName+Constant.REMOVE_POSTFIX,method = RequestMethod.POST )		
	public BaseResponse delete(int id) {
		// TODO Auto-generated method stub
		return service.remove(id);
	}

	@Override
	@RequestMapping( value = Constant.API_PREFIX+controllerName+Constant.GET_POSTFIX)			
	public BaseResponse get(int id) {
		// TODO Auto-generated method stub
		return service.getById(id);
	}

	@Override
	@RequestMapping( value = Constant.API_PREFIX+controllerName+Constant.GET_ALL_POSTFIX)				
	public BaseResponse getAll() {
		// TODO Auto-generated method stub
		return service.getAll();
	}
	
	@RequestMapping( value = Constant.API_PREFIX+controllerName+"/search")				
	public BaseResponse getAll(@RequestParam( name = "idCat",defaultValue = "" )int idCat,
			@RequestParam( name = "name",defaultValue = "" ) String name) {
		// TODO Auto-generated method stub
		return service.getBySearch(idCat, name, 0);
	}
	
	@RequestMapping( value = Constant.API_PREFIX+controllerName+"/isExistCode")	
	public BaseResponse issExistCode(String code){
		return service.getCode(code);
	}

}
