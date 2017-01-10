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

	@Column( name = "product_product_name" )
	String productName;
	
	@Column( name = "product_product_code" )
	String productCode;	
	
	@Column( name = "ordermember_order_id" )
	int orderId;
	
	public OrderItem() {
		// TODO Auto-generated constructor stub
	}
	
	
	public OrderItem(int id, int qty, int finalPrice, int productId, String productName, String productCode,
			int orderId) {
		super();
		this.id = id;
		this.qty = qty;
		this.finalPrice = finalPrice;
		this.productId = productId;
		this.productName = productName;
		this.productCode = productCode;
		this.orderId = orderId;
	}




	public String getProductName() {
		return productName;
	}




	public void setProductName(String productName) {
		this.productName = productName;
	}




	public String getProductCode() {
		return productCode;
	}




	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}




	public int getOrderId() {
		return orderId;
	}




	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
