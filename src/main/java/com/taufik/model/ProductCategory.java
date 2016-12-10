package com.taufik.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "product_category" )
public class ProductCategory {
	
	@Id
	@GeneratedValue
	@Column( name = "product_category" )
	int id;
	
	@Column( name = "product_category_name" )
	String name;
	
	@Column( name = "product_category_icon" )
	String icon;
	
	@Column( name = "product_category_desc" )
	String desc;

	public ProductCategory(int id, String name, String icon, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.icon = icon;
		this.desc = desc;
	}
	
	
	public ProductCategory() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getIcon() {
		return icon;
	}


	public void setIcon(String icon) {
		this.icon = icon;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
