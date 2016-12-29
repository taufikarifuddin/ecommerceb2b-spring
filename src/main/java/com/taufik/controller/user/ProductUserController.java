package com.taufik.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taufik.other.PageAttribute;

@Controller
public class ProductUserController {

	@RequestMapping( value = "/product/productDetail/{id}" )
	public String detailProduct(@PathVariable( name = "id" )int id,Model model){
		PageAttribute.setAttribut(model,"productDetail","Produk Detail",id);		
		return "user/index";
	}
	
}
