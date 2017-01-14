package com.taufik.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javassist.expr.NewArray;

@Entity
@Table( name = "order_member" )
public class Order {
	
	@Id
	@GeneratedValue
	@Column( name = "member_order_id" )
	int id;
	
	@Column( name = "membermember_id" )
	int memberId;
	
	@Column( name = "order_statusorder_status_id" )
	OrderStatus statusId;
	
	@Column( name = "order_date_created" )
	String orderCreated;
	
	@Column( name = "member_member_name" )
	String memberName; 
	
	@Column( name = "alamat_pengiriman" )
	String address;
	
	@OneToMany( mappedBy = "orderId" )
	List<OrderItem> orderItems;
	
	public String getAddress() {
		return address;
	}
	
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public Order(int id, int memberId, OrderStatus statusId, String orderCreated, String memberName, String address) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.statusId = statusId;
		this.orderCreated = orderCreated;
		this.memberName = memberName;
		this.address = address;
	}
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public OrderStatus getStatusId() {
		return statusId;
	}

	public void setStatusId(OrderStatus statusId) {
		this.statusId = statusId;
	}

	public String getOrderCreated() {
		return orderCreated;
	}

	public void setOrderCreated(String orderCreated) {
		this.orderCreated = orderCreated;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPaymentId() {
		return address;
	}

	public void setAddress(String paymentId) {
		this.address = paymentId;
	}
}
