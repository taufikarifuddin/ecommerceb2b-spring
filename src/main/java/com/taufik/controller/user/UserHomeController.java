package com.taufik.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taufik.other.PageAttribute;

@Controller
public class UserHomeController {
	
	@RequestMapping("/")	
	public String home(Model model){
		PageAttribute.setAttribut(model,"home","Home");
		return "user/index";
	}	
	
	@RequestMapping( value = "/user/login" )
	public String login(Model model){
		PageAttribute.setAttribut(model,"login","Login");
		return "user/index";		
	}
	
	@RequestMapping( value = "/user/profile" )
	public String profile(Model model){
		PageAttribute.setAttribut(model,"profile","Profile");		
		return "user/index";
	}
}
