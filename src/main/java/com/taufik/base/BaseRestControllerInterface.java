package com.taufik.base;

import org.springframework.validation.BindingResult;

public interface BaseRestControllerInterface<T> {
	public BaseResponse update(T data,BindingResult bindingResult);
	public BaseResponse delete(int id);
	public BaseResponse get(int id);	
	public BaseResponse getAll();	
}
