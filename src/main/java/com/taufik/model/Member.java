package com.taufik.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "member" )
public class Member {
	
	@Id
	@GeneratedValue
	@Column( name = "member_id" )
	int id;
	
	@Column( name = "member_gender" )
	int genderID;
	
	@Column( name = "member_name" )
	String name;
	
	@Column( name = "member_email_address" )
	String address;
	
	@Column( name = "member_contact" )
	String contact;
	
	@Column( name = "member_contact2" )
	String contact2;
	
	@Column( name = "member_password" )
	String password;
	
	@Column( name = "member_is_active",columnDefinition = "default '1'" )
	boolean isActive;
	
	@Column(name = "member_last_login")
	String lastLogin;
	
	@Column( name = "member_datecreated" )
	String dateCreated;
	
	@Column( name = "member_account_modified" )
	String lastModificationDate;
	
	@Column( name = "member_rolemember_role_id" )
	int roleId;

	public Member(int id, int genderID, String name, String address, String contact, String contact2, String password,
			boolean isActive, String lastLogin, String dateCreated, String lastModificationDate, int roleId) {
		super();
		this.id = id;
		this.genderID = genderID;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.contact2 = contact2;
		this.password = password;
		this.isActive = isActive;
		this.lastLogin = lastLogin;
		this.dateCreated = dateCreated;
		this.lastModificationDate = lastModificationDate;
		this.roleId = roleId;
	}
	
	
	public Member() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getGenderID() {
		return genderID;
	}


	public void setGenderID(int genderID) {
		this.genderID = genderID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getContact2() {
		return contact2;
	}


	public void setContact2(String contact2) {
		this.contact2 = contact2;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public String getLastLogin() {
		return lastLogin;
	}


	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}


	public String getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}


	public String getLastModificationDate() {
		return lastModificationDate;
	}


	public void setLastModificationDate(String lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	
	
	
	
}
