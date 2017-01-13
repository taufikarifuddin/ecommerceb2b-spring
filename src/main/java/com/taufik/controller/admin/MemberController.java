package com.taufik.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taufik.base.BaseControllerInterface;
import com.taufik.model.Member;
import com.taufik.other.Constant;
import com.taufik.other.PageAttribute;

@Controller
public class MemberController implements BaseControllerInterface<Member>{

	private static final String controllerName = "member";	
	
	
	public String add(Model model) {		
		return null;
	}

	@Override
	@RequestMapping( value = Constant.ADMIN_ROUTE+"/"+controllerName )
	public String index(Model model) {		
		PageAttribute.setAttribut(model, controllerName, Constant.INDEX_ACTION, "Member");
		return "admin/index";
	}

	@Override
	@RequestMapping( value = Constant.ADMIN_ROUTE+"/"+controllerName+"/edit/{id}" )	
	public String edit(@PathVariable(name = "id") int id,Model model) {				
		PageAttribute.setAttribut(model, controllerName, Constant.EDIT_ACTION, "Detail Member",id);		
		return "admin/index";
	}

	@Override
	@RequestMapping( value = Constant.ADMIN_ROUTE+"/"+controllerName+"/remove/{id}" )		
	public String delete(@PathVariable(name = "id") int id,Model model) {
		PageAttribute.setAttribut(model, controllerName, Constant.REMOVE_ACTION, "Hapus Member",id);		
		return "admin/index";
	}
	
}
