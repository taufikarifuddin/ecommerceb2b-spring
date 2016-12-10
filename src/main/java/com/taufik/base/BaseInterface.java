package com.taufik.base;


public interface BaseInterface<T> {
	public BaseResponse save(T data);
	public BaseResponse edit(T data);
	public BaseResponse remove(int id);
	public BaseResponse getById(int id);
	public BaseResponse getAll();	
}
