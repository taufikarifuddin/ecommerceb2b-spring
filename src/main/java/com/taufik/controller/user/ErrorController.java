package com.taufik.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taufik.other.PageAttribute;

@Controller
public class ErrorController {
	
	@RequestMapping( value = "/error/notfound" )
	public String notfound(Model model){
		PageAttribute.setAttribut(model,"/error/404error","Home");
		return "user/index";
	}
	
}
