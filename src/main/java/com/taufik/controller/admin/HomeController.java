package com.taufik.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taufik.other.Constant;

@Controller
public class HomeController{
	
	@RequestMapping( value = Constant.ADMIN_ROUTE+"/login" )
	public String login(){
		return "admin/home/login";
	}
	
	@RequestMapping( value  = Constant.ADMIN_ROUTE+"/dashboard" )
	public String dashboard(){
		return "admin/home/dashboard";
	}
	
	
	@RequestMapping("/admin/logout")
	public String logout(){
		return "";
	}
}
