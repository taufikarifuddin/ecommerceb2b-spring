package com.taufik.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "product_image" )
public class ProductImage {
	
	@Id
	@GeneratedValue
	@Column( name = "product_image_id" )
	int id;
	
	@Column( name = "product_image_image" )
	String image;
	
	@Column( name = "productproduct_id" )
	int productId;
	
	public ProductImage() {
		// TODO Auto-generated constructor stub
	}

	public ProductImage(int id, String image, int productId) {
		super();
		this.id = id;
		this.image = image;
		this.productId = productId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
	
}
