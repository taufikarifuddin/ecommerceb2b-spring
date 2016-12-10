package com.taufik.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "banners" )
public class Banner {
	
	@Id
	@GeneratedValue
	@Column( name = "banner_id" )
	int id;
	
	@Column( name = "banner_title" )
	String title;
	
	@Column( name = "banner_image" )
	String image;
	
	@Column( name = "date_added" )
	String dateAdded;
	
	@Column( name = "is_visible" )
	boolean isVisible;
	
	@Column( name = "banner_order" )
	int order;

	public Banner() {
		// TODO Auto-generated constructor stub
	}

	public Banner(int id, String title, String image, String dateAdded, boolean isVisible, int order) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.dateAdded = dateAdded;
		this.isVisible = isVisible;
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	
}
