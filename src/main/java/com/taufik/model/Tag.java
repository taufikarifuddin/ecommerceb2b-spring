package com.taufik.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "tag" )
public class Tag {

	@Id
	@GeneratedValue
	@Column( name = "tag_id" )
	int id;
	
	@Column( name = "tag_name" )
	String name;
	
}
