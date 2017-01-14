package com.taufik.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.taufik.customvalidator.NotZeroValue;


@Entity
@Table( name = "product" )
public class Product {

	@Id
	@GeneratedValue
	@Column( name = "product_id" )
	int id;
		
	@Column( name = "product_name" )
	@NotNull( message = "Nama tidak boleh kosong" )
	String name;
	
	@Column( name = "product_date_added" )	
	String dateAdded;
	
	@Column( name = "product_last_modified" )
	String lastModified;
	
	@Column( name = "product_desc" )
	@NotNull( message = "Deskripsi Produk tidak boleh kosong" )
	String desc;
		
	@Column( name = "product_viewed" )
	int viewedCounter;
	
	@Column( name = "product_default_price" )
	@NotZeroValue( message = "Harga tidak boleh kosong" )
	int price;
	
	@Column( name = "is_visible" )
	int isVisible;
	
	@Column( name = "product_categoryproduct_category_id" )
	@NotZeroValue( message = "Kategori tidak boleh kosong" )	
	int categoryId;
	
	@Column( name = "product_code" )
	@NotNull( message = "Kode Barang tidak boleh kosong" )
	String code;

	@OneToMany( mappedBy = "productId" )
	Set<ProductImage> images;
	
	@OneToMany( mappedBy = "productId" )
	@OrderBy(value = "tracehold")
	Set<ProductDiscount> discounts;	
	
	@ManyToOne( cascade = CascadeType.ALL )
	@JoinColumn( name = "product_categoryproduct_category_id",insertable = false, updatable = false )
	ProductCategory category;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	

	public Product(int id, String name, String dateAdded, String lastModified, String desc, int viewedCounter,
			int price, int isVisible, int categoryId, String code,Set<ProductImage> images,
			Set<ProductDiscount> discount,ProductCategory category) {
		super();
		this.images = images;
		this.id = id;
		this.name = name;
		this.dateAdded = dateAdded;
		this.lastModified = lastModified;
		this.desc = desc;
		this.viewedCounter = viewedCounter;
		this.price = price;
		this.isVisible = isVisible;
		this.categoryId = categoryId;
		this.code = code;
		this.discounts = discount;
		this.category = category;
	}
	
	public ProductCategory getCategory() {
		return category;
	}
	
	public Set<ProductDiscount> getDiscounts() {
		return discounts;
	}
	
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	
	public void setDiscounts(Set<ProductDiscount> discounts) {
		this.discounts = discounts;
	}
	
	public void setImages(Set<ProductImage> images) {
		this.images = images;
	}
	
	public Set<ProductImage> getImages() {
		return images;
	}

	public void setIsVisible(int isVisible) {
		this.isVisible = isVisible;
	}
	
	public int getIsVisible() {
		return isVisible;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getViewedCounter() {
		return viewedCounter;
	}

	public void setViewedCounter(int viewedCounter) {
		this.viewedCounter = viewedCounter;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
