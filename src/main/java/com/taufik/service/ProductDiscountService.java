package com.taufik.service;

import org.springframework.stereotype.Service;

import com.taufik.base.BaseResponse;
import com.taufik.base.BaseService;
import com.taufik.model.ProductDiscount;
import com.taufik.repository.ProductDiscountRepository;

@Service
public class ProductDiscountService extends BaseService<ProductDiscount, ProductDiscountRepository>{
	
	public BaseResponse getByIdProduct(int id) {
		BaseResponse response = this.setResponse();
		try{
			response.setDataResponse( this.repo.findByProductId(id) );
			response.setErrorResponse(false);
		}catch (Exception e) {
			response.setMessageResponse(e.getMessage());
			// TODO: handle exception
		}
		return response;
	}

	
}
