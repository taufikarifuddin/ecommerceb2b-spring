package com.taufik.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taufik.base.BaseResponse;
import com.taufik.base.BaseService;
import com.taufik.model.Product;
import com.taufik.repository.ProductRepository;

@Service
public class ProductService extends BaseService<Product, ProductRepository>{

	public BaseResponse getCode(String code){
		BaseResponse response = this.setResponse();
		try{
			List<Product> products = this.repo.findByCode(code);
			if( products.size() == 0){
				response.setDataResponse(true);
			}else{
				response.setDataResponse(products);				
			}
			response.setErrorResponse(false);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return response;
	}
	
}
