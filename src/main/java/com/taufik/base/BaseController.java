package com.taufik.base;

import org.springframework.validation.BindingResult;

public interface BaseController<T> {
	public BaseResponse update(T data,BindingResult bindingResult);
	public BaseResponse delete(int id);
	public BaseResponse get(int id);	
	public BaseResponse getAll();	
	public BaseResponse doUpdate(T data,BindingResult bindingResult);
}
