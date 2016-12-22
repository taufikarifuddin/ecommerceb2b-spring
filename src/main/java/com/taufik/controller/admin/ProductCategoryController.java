package com.taufik.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taufik.base.BaseControllerInterface;
import com.taufik.model.ProductCategory;
import com.taufik.other.Constant;
import com.taufik.other.PageAttribute;

@Controller
public class ProductCategoryController implements BaseControllerInterface<ProductCategory>{
	
	private static final String controllerName = "productCategory";	
	
	
	@Override
	@RequestMapping( value = Constant.ADMIN_ROUTE+"/productCategory/add" )	
	public String add(Model model) {		
		PageAttribute.setAttribut(model, controllerName, Constant.ADD_ACTION, "Tambah Kategori Produk");		
		return "admin/index";
	}

	@Override
	@RequestMapping( value = Constant.ADMIN_ROUTE+"/productCategory" )
	public String index(Model model) {		
		PageAttribute.setAttribut(model, controllerName, Constant.INDEX_ACTION, "Kategori Produk");
		return "admin/index";
	}

	@Override
	@RequestMapping( value = "/admin/productCategory/edit/{id}" )	
	public String edit(@PathVariable(name = "id") int id,Model model) {				
		PageAttribute.setAttribut(model, controllerName, Constant.EDIT_ACTION, "Edit Kategori Produk",id);		
		return "admin/index";
	}

	@Override
	@RequestMapping( value = "/admin/productCategory/remove/{id}" )		
	public String delete(@PathVariable(name = "id") int id,Model model) {
		PageAttribute.setAttribut(model, controllerName, Constant.REMOVE_ACTION, "Hapus Kategori Produk",id);		
		return "admin/index";
	}
	
}
