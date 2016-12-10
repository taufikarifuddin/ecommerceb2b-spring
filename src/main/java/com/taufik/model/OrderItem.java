package com.taufik.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "order_item" )
public class OrderItem {

	@Id
	@GeneratedValue
	@Column( name = "member_item_order_id" )
	int id;
	
	@Column( name = "order_item_qty" )
	int qty;
	
	@Column( name = "order_item_final_price" )
	int finalPrice;
	
	@Column( name = "productproduct_id" )
	int productId;

	public OrderItem() {
		// TODO Auto-generated constructor stub
	}
	
	
	public OrderItem(int id, int qty, int finalPrice, int productId) {
		super();
		this.id = id;
		this.qty = qty;
		this.finalPrice = finalPrice;
		this.productId = productId;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
	
}
