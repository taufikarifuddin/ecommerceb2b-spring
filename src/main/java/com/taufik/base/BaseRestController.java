package com.taufik.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

public class BaseRestController<T,K extends BaseService<T, JpaRepository<T,Integer>>> 
	implements BaseRestControllerInterface<T>{	
	
	private String controllerName;
	private K repo;
	
	@Override
	public BaseResponse update(T data, BindingResult bindingResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResponse delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResponse get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping( "/api/productCategory/getAll" )
	public BaseResponse getAll() {
		return repo.getAll();
	}

	@Override
	public BaseResponse doUpdate(T data, BindingResult bindingResult) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
		System.out.println("called "+this.controllerName);
	}
	
	@Autowired
	public void setRepo(K repo) {
		this.repo = repo;
		
	}	
}
