package com.taufik.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taufik.other.PageAttribute;

@Controller
public class UserHomeController {
	
	@RequestMapping("/")	
	public String home(Model model){
		PageAttribute.setAttribut(model, "Home");
		return "user/index";
	}
	
}
