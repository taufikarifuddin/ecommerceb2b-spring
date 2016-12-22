package com.taufik.controller.rest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.taufik.base.BaseResponse;
import com.taufik.other.Constant;

@RestController
public class ImageRestController {


	public static final String UPLOAD_PATH = "/upload/";


	@RequestMapping(value = Constant.API_PREFIX+"image/upload")				
	public BaseResponse upload(@RequestParam( name = "file" ) MultipartFile file){
		return uploadFile(file);
	}
	
	
	private static BaseResponse uploadFile(MultipartFile file){
		
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
	
	private static String getExtensionFromFile(String name){
		String[] data = name.split("\\.");	
		if( data.length > 1 ){
			return data[data.length - 1];
		}
		return null;
	}
	
}
