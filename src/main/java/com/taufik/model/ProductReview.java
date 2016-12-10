package com.taufik.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "product_review" )
public class ProductReview {
	
	@Id
	@GeneratedValue
	@Column( name = "product_review_id" )
	int id;
	
	@Column( name = "product_review_rating" )
	double rating;
	
	@Column( name= "product_review_comment" )
	String comment;
	
	@Column( name = "productproduct_id" )
	int productId;
	
	@Column( name = "membermember_id" )
	int memberID;
	
	public ProductReview() {
		// TODO Auto-generated constructor stub
	}

	public ProductReview(int id, double rating, String comment, int productId, int memberID) {
		super();
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.productId = productId;
		this.memberID = memberID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	
	
}
