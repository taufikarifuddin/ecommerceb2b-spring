package com.taufik.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taufik.base.BaseControllerInterface;
import com.taufik.model.Order;
import com.taufik.other.Constant;
import com.taufik.other.PageAttribute;

@Controller
public class OrderController implements BaseControllerInterface<Order>{
	
	private static final String controllerName = "order";
	
	@Override
	@RequestMapping( value = Constant.ADMIN_ROUTE+"/"+controllerName+"/edit/{id}" )	
	public String edit(@PathVariable(name = "id") int id,Model model) {				
		PageAttribute.setAttribut(model, controllerName, Constant.EDIT_ACTION, "Edit Kategori Produk",id);		
		return "admin/index";
	}

	@Override
	@RequestMapping( value = Constant.ADMIN_ROUTE+"/"+controllerName )
	public String index(Model model) {
		PageAttribute.setAttribut(model, controllerName, Constant.INDEX_ACTION, "Tambah Kategori Produk");		
		return "admin/index";
	}

	@Override
	public String delete(int id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String add(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
