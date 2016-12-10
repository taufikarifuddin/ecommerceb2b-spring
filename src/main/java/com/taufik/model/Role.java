package com.taufik.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "member_role" )
public class Role {
	
	@Id
	@GeneratedValue
	@Column( name = "member_role_id")
	int id;
	
	@Column( name = "member_role_key" )
	String roleCode;
	
	@Column( name = "member_role_desc" )
	String desc;
	
	
	public Role() {
		// TODO Auto-generated constructor stub
	}


	public Role(int id, String roleCode, String desc) {
		super();
		this.id = id;
		this.roleCode = roleCode;
		this.desc = desc;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getRoleCode() {
		return roleCode;
	}


	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}
