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
	
	@RequestMapping( value = "/user/cart/checkout")
	public String checkout(Model model){
		PageAttribute.setAttribut(model,"checkOut","Check Out");		
		return "user/index";		
	}
	
	@RequestMapping( value = "/user/historyOrder" )
	public String orderHistory(Model model){
		PageAttribute.setAttribut(model,"historyOrder","Check Out");				
		return "user/index";
	}
}	
