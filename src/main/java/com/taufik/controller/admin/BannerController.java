package com.taufik.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taufik.base.BaseControllerInterface;
import com.taufik.model.Banner;
import com.taufik.other.Constant;
import com.taufik.other.PageAttribute;
import com.taufik.service.BannerService;

@Controller
public class BannerController implements BaseControllerInterface<Banner>{

	@Override
	@RequestMapping( value = Constant.ADMIN_ROUTE+"/"+BannerService.CONTROLLER_NAME+"/add" )	
	public String add(Model model) {		
		PageAttribute.setAttribut(model, BannerService.CONTROLLER_NAME, Constant.ADD_ACTION, "Tambah Banner");		
		return "admin/index";
	}

	@Override
	@RequestMapping( value = Constant.ADMIN_ROUTE+"/"+BannerService.CONTROLLER_NAME )
	public String index(Model model) {		
		PageAttribute.setAttribut(model, BannerService.CONTROLLER_NAME, Constant.INDEX_ACTION, "Banner");
		return "admin/index";
	}

	@Override
	public String edit(@PathVariable(name = "id") int id,Model model) {				
		return "";
	}

	@Override
	@RequestMapping( value = Constant.ADMIN_ROUTE+"/"+BannerService.CONTROLLER_NAME+"/remove/{id}")	
	public String delete(@PathVariable(name = "id") int id,Model model) {
		PageAttribute.setAttribut(model, BannerService.CONTROLLER_NAME, Constant.REMOVE_ACTION, "Hapus Banner",id);		
		return "admin/index";
	}

}
