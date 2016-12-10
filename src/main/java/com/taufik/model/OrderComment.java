package com.taufik.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "order_comment" )
public class OrderComment {
	
	@Id
	@GeneratedValue
	@Column( name = "order_comment_id" )
	int id;
	
	@Column( name =  "order_comment_message" )
	String message;
	
	@Column( name = "order_comment_date_added" )
	String date;
	
	@Column( name = "membermember_id" )
	int memberId;
	
	@Column( name = "ordermember_order_id" )
	String orderId;

	public OrderComment(int id, String message, String date, int memberId, String orderId) {
		super();
		this.id = id;
		this.message = message;
		this.date = date;
		this.memberId = memberId;
		this.orderId = orderId;
	}
	
	public OrderComment() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	
}
