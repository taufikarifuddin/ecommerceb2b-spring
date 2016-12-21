package com.taufik.base;

import java.util.HashMap;

import com.taufik.other.Constant;

public class BaseResponse {
	
	HashMap<String,Object> baseResponse = new HashMap<String, Object>();
	
	public BaseResponse(String message,boolean error,Object data) {
		baseResponse.put(Constant.MESSAGE_RESPONS_PARAMS, message);
		baseResponse.put(Constant.ERROR_RESPONS_PARAMS, error);
		baseResponse.put(Constant.DATA_RESPONS_PARAMS, data);		
	}
	
	public BaseResponse(String message) {
		baseResponse.put(Constant.MESSAGE_RESPONS_PARAMS, message);
	}

	public BaseResponse(boolean error) {
		baseResponse.put(Constant.ERROR_RESPONS_PARAMS, error);
	}
	
	public BaseResponse(Object data) {
		baseResponse.put(Constant.DATA_RESPONS_PARAMS, data);		
	}
	
	
	public BaseResponse(String message,boolean error) {
		baseResponse.put(Constant.MESSAGE_RESPONS_PARAMS, message);
		baseResponse.put(Constant.ERROR_RESPONS_PARAMS, error);
	}
		
	
	public BaseResponse(Object data,String message) {
		baseResponse.put(Constant.MESSAGE_RESPONS_PARAMS, message);
		baseResponse.put(Constant.DATA_RESPONS_PARAMS, data);
	}
	
	public BaseResponse(Object data,boolean error) {
		baseResponse.put(Constant.ERROR_RESPONS_PARAMS, error);
		baseResponse.put(Constant.DATA_RESPONS_PARAMS, data);
	}

	
	public BaseResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public void setMessageResponse(String message){
		baseResponse.put(Constant.MESSAGE_RESPONS_PARAMS, message);
	}
	
	public void setErrorResponse(boolean error){
		baseResponse.put(Constant.ERROR_RESPONS_PARAMS, error);
	}

	public void setDataResponse(Object message){
		baseResponse.put(Constant.DATA_RESPONS_PARAMS, message);
	}
	
	public void setUrlResponse(String url){
		baseResponse.put(Constant.URL, url);
	}

	
	public void putOtherResponse(String key, Object value){
		this.baseResponse.put(key, value);
	}
	
	public boolean getErrorStatus() {
		return (boolean) baseResponse.get(Constant.ERROR_RESPONS_PARAMS);
	}

	
	public HashMap<String, Object> getBaseResponse() {
		return baseResponse;
	}
	
}
