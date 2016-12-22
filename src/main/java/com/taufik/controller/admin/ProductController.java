package com.taufik.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taufik.base.BaseControllerInterface;
import com.taufik.model.Product;
import com.taufik.other.Constant;
import com.taufik.other.PageAttribute;

@Controller
public class ProductController implements BaseControllerInterface<Product>{

	private final String controllerName = "product";
	
	@Override
	@RequestMapping( value = Constant.ADMIN_ROUTE+"/"+controllerName+"/add" )	
	public String add(Model model) {		
		PageAttribute.setAttribut(model, controllerName, Constant.ADD_ACTION, "Tambah Produk");		
		return "admin/index";
	}

	@Override
	@RequestMapping( value = Constant.ADMIN_ROUTE+"/"+controllerName )
	public String index(Model model) {		
		PageAttribute.setAttribut(model, controllerName, Constant.INDEX_ACTION, "Produk");
		return "admin/index";
	}

	@Override
	@RequestMapping( value = "/admin/"+controllerName+"/edit/{id}" )	
	public String edit(@PathVariable(name = "id") int id,Model model) {				
		System.out.println("IDnya gan : "+id);
		PageAttribute.setAttribut(model, controllerName, Constant.EDIT_ACTION, "Produk",id);		
		return "admin/index";
	}

	@Override
	@RequestMapping( value = "/admin/"+controllerName+"/remove/{id}" )		
	public String delete(@PathVariable(name = "id") int id,Model model) {
		System.out.println("IDnya gan : "+id);		
		PageAttribute.setAttribut(model, controllerName, Constant.REMOVE_ACTION, "Hapus Produk",id);		
		return "admin/index";
	}
	

	
}
