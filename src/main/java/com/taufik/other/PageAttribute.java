package com.taufik.other;

import org.springframework.ui.Model;

public class PageAttribute {

	public static void setAttribut(Model model,String controllerName,String action,String title){
		model.addAttribute(Constant.VIEW_INDEX,controllerName);
		model.addAttribute(Constant.PAGE_INDEX,action);
		model.addAttribute(Constant.TITLE_INDEX,title);	
	}
	
	public static void setAttribut(Model model,String controllerName,String action,String title,int index){
		model.addAttribute(Constant.VIEW_INDEX,controllerName);
		model.addAttribute(Constant.PAGE_INDEX,action);
		model.addAttribute(Constant.TITLE_INDEX,title);	
		model.addAttribute(Constant.ID_INDEX,index);			
	}
	
	public static void setAttribut(Model model,String page,String title,int index){
		model.addAttribute(Constant.PAGE_INDEX,page);
		model.addAttribute(Constant.TITLE_INDEX,title);	
		model.addAttribute(Constant.ID_INDEX,index);			
	}
	
	public static void setAttribut(Model model,String title){
		model.addAttribute(Constant.TITLE_INDEX,title);			
	}
	
	public static void setAttribut(Model model,String view,String title){
		model.addAttribute(Constant.PAGE_INDEX,view);	
		model.addAttribute(Constant.TITLE_INDEX,title);	
	}
	
}
