package com.taufik.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.taufik.customvalidator.NotZeroValue;

@Entity
@Table( name = "product_discount" )
public class ProductDiscount {
	
	@Id
	@GeneratedValue
	@Column( name = "product_discount_id" )
	int id;
	
	@Column( name = "product_discount_tracehold" )
	@NotZeroValue( message = "Batas Pembelian tidak boleh kosong" )		
	int tracehold;
	
	@Column( name = "product_discount_price" )
	@NotZeroValue( message = "Discount tidak boleh kosong" )	
	int discount;
	
	@Column( name = "productproduct_id" )	
	int productId;
	
	public ProductDiscount() {
		// TODO Auto-generated constructor stub
	}

	public ProductDiscount(int id, int tracehold, int discount, int productId) {
		super();
		this.id = id;
		this.tracehold = tracehold;
		this.discount = discount;
		this.productId = productId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTracehold() {
		return tracehold;
	}

	public void setTracehold(int tracehold) {
		this.tracehold = tracehold;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
}
