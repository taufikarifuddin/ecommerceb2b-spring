package com.taufik.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "member_address" )
public class MemberAddress {

	@Id
	@GeneratedValue
	@Column( name = "member_address_id" )
	int id;
	
	@Column( name = "member_stress_address_primary" )
	String addressPrimary;
	
	@Column( name = "member_street_address" )
	String address;
	
	@Column( name = "member_address_city" )
	String city;
	
	@Column( name = "member_address_province" )
	String province;
	
	@Column( name = "member_address_country" )
	String country;
	
	@Column( name = "member_address_post_code" )
	String postCode;
	
	@Column( name = "membermember_id" )
	int memberId;
	
	public MemberAddress() {
		// TODO Auto-generated constructor stub
	}

	public MemberAddress(int id, String addressPrimary, String address, String city, String province, String country,
			String postCode, int memberId) {
		super();
		this.id = id;
		this.addressPrimary = addressPrimary;
		this.address = address;
		this.city = city;
		this.province = province;
		this.country = country;
		this.postCode = postCode;
		this.memberId = memberId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressPrimary() {
		return addressPrimary;
	}

	public void setAddressPrimary(String addressPrimary) {
		this.addressPrimary = addressPrimary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	
}
