package com.taufik.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taufik.other.PageAttribute;

@Controller
public class CartController {
	
	@RequestMapping( value = "/user/cart" )
	public String detailCart(Model model){
		PageAttribute.setAttribut(model,"cartDetail","Cart Detail");		
		return "user/index";
	}
	
}	