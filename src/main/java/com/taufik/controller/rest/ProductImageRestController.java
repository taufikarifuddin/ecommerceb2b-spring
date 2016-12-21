package com.taufik.controller.rest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.validation.Valid;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.taufik.base.BaseResponse;
import com.taufik.model.ProductImage;
import com.taufik.other.Constant;
import com.taufik.service.ProductImageService;

@RestController
public class ProductImageRestController {

	@Autowired
	private ProductImageService service;
	private final String controllerName = "productImage";
	
	public static final String UPLOAD_PATH = "/upload/";
		
	@RequestMapping( value = Constant.API_PREFIX+controllerName+Constant.UPDATE_POSTFIX,method = RequestMethod.POST )	
	public BaseResponse update(@RequestBody @Valid ProductImage data,BindingResult bindingResult) {
		// TODO Auto-generated method stub		
		
		if( bindingResult.hasErrors() ){	
			return new BaseResponse(bindingResult.getAllErrors(),true);
		}
		BaseResponse response = service.save(data);
		response.setDataResponse(data);
		return response;
	}

	@RequestMapping( value = Constant.API_PREFIX+controllerName+Constant.REMOVE_POSTFIX,method = RequestMethod.POST )		
	public BaseResponse delete(int id) {
		// TODO Auto-generated method stub
		return service.remove(id);
	}

	@RequestMapping(value = Constant.API_PREFIX+controllerName+Constant.GET_ALL_POSTFIX)				
	public BaseResponse getAllByIdProduct(@RequestParam( defaultValue = "0",required = true ) int id) {
		// TODO Auto-generated method stub
		return service.getByIdProduct(id);
	}

	@RequestMapping(value = Constant.API_PREFIX+controllerName+"/upload")				
	public BaseResponse upload(@RequestParam( name = "file" ) MultipartFile file){
		return uploadFile(file);
	}
	
	public static BaseResponse uploadFile(MultipartFile file){
		
		try {			
			String newName = new Timestamp( System.currentTimeMillis() ).getTime()+"."+getExtensionFromFile(file.getOriginalFilename());
			Path path = Paths.get(UPLOAD_PATH+newName);
			File uploadDir = new File(UPLOAD_PATH);
			
			if( !uploadDir.exists() ){
				uploadDir.mkdirs();
			}			
			
			InputStream inputStream = file.getInputStream();
			OutputStream outputStream = Files.newOutputStream(path);
			IOUtils.copy(inputStream, outputStream);
			return new BaseResponse(newName, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new BaseResponse(true);
	}
	
	public static String getExtensionFromFile(String name){
		String[] data = name.split("\\.");	
		if( data.length > 1 ){
			return data[data.length - 1];
		}
		return null;
	}
}
