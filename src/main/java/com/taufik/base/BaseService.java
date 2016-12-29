package com.taufik.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class BaseService<T,K extends JpaRepository<T, Integer>>{	

	protected K repo;
	
	public BaseResponse save(T data) {
		BaseResponse response = this.setResponse();
		try{
			repo.save(data);
			response.setErrorResponse(false);
		}catch (Exception e) {
			response.setMessageResponse(e.getMessage());
			// TODO: handle exception
		}
		return response;
	}

	
	public BaseResponse remove(int id) {
		BaseResponse response = this.setResponse();
		try{
			repo.delete(id);
			response.setErrorResponse(false);
		}catch(Exception e){
			response.setMessageResponse(e.getMessage());
			
		}
		return response;
	}

	public BaseResponse getById(int id) {		
		BaseResponse response = this.setResponse();
		try{
			response.setErrorResponse(false);
			response.setDataResponse(repo.findOne(id));
		}catch (Exception e) {
			// TODO: handle exception
			response.setDataResponse(null);
			response.setMessageResponse(e.getMessage());
		}
		return response;
	}
	

	public BaseResponse getAll() {
		BaseResponse response = this.setResponse();
		try{
			response.setErrorResponse(false);
			response.setDataResponse(repo.findAll());
		}catch(Exception e){
			response.setMessageResponse(e.getMessage());
			response.setDataResponse(null);
			
		}
		return response;
	}
	
	public BaseResponse setResponse(){
		BaseResponse baseResponse= new BaseResponse();
		baseResponse.setErrorResponse(true);
		return baseResponse;		
	};
	
	@Autowired
	public void setRepo(K repo) {
		this.repo = repo;
		
	}
	
	
}
