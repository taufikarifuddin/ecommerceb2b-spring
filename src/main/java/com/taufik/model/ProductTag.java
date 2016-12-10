package com.taufik.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "product_tag" )
public class ProductTag {
	
	@Id
	@GeneratedValue
	@Column( name = "product_tag_id" )
	int id;
	
	@Column( name= "productproduct_id" )
	int productId;
	
	@Column( name = "tagtag_id" )
	int tagId;
	
	
	public ProductTag() {
		// TODO Auto-generated constructor stub
	}


	public ProductTag(int id, int productId, int tagId) {
		super();
		this.id = id;
		this.productId = productId;
		this.tagId = tagId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getTagId() {
		return tagId;
	}


	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	
	
}
