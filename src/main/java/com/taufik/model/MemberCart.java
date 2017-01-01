package com.taufik.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table( name = "member_cart" )
public class MemberCart {
	
	@Id
	@GeneratedValue
	@Column( name = "member_cart_id" )
	int id;
	
	@Column( name = "member_cart_added" )
	String dateAdded;
	
	@Column( name = "member_cart_qty" )
	int qty;
	
	@Column( name = "membermember_id" )
	int memberId;
	
	@Column( name= "productproduct_id" )
	int productId;
	
	@OneToOne
	@JoinColumn( name = "productproduct_id",insertable = false,updatable = false )
	Product product;

	public MemberCart(int id, String dateAdded, int qty, int memberId, int productId,Product product) {
		super();
		this.id = id;
		this.dateAdded = dateAdded;
		this.qty = qty;
		this.memberId = memberId;
		this.productId = productId;
		this.product = product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public MemberCart() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
}
