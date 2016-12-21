package com.taufik.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.taufik.customvalidator.NotZeroValue;

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
	
	@Column( name = "product_image_order" )
	@NotZeroValue( message = "Product Order tidak boleh kosong" ) 
	int productOrder;
	
	public ProductImage() {
		// TODO Auto-generated constructor stub
	}

	public ProductImage(int id, String image, int productId,int productOrder) {
		super();
		this.id = id;
		this.image = image;
		this.productId = productId;
		this.productOrder = productOrder;
	}

	public int getProductOrder() {
		return productOrder;
	}

	public void setProductOrder(int productOrder) {
		this.productOrder = productOrder;
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
