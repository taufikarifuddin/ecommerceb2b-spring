package com.taufik.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "proof_of_payment" )
public class ProofOfPayment {
	
	@Id
	@GeneratedValue
	@Column( name = "proof_of_payment_id" )
	int id;
	
	@Column( name = "proof_of_payment_image" )
	String image;
	
	@Column( name = "proof_of_payment_upload_date" )
	String date;
	
	@Column( name = "ordermember_order_id" )
	int orderId;
	
	@Column( name = "is_valid" )
	boolean isValid;
	
	
	public ProofOfPayment() {
		// TODO Auto-generated constructor stub
	}


	public ProofOfPayment(int id, String image, String date, int orderId, boolean isValid) {
		super();
		this.id = id;
		this.image = image;
		this.date = date;
		this.orderId = orderId;
		this.isValid = isValid;
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


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public boolean isValid() {
		return isValid;
	}


	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	
}
