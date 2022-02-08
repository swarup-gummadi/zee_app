package com.learning.dto;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Entity	//ORM Mapping purpose
@Table(name = "register", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})	//table naming and unique constraint
public class Register {

	@Setter(value = AccessLevel.NONE)
	@Id	//primary key
	@Column(name = "regId")	//column with name
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@Setter(value = AccessLevel.NONE)
	@Email
	@Size(max=50)
	@NotBlank
	private String email;
	
	@Setter(value = AccessLevel.NONE)
	@Size(max=50)
	@NotBlank
	private String name;
	
	@Setter(value = AccessLevel.NONE)
	@NotBlank
	@Size(max=100)
	private String password;
	
	@Setter(value = AccessLevel.NONE)
	@Size(max=100)
	private String address;
	
	@OneToOne(mappedBy = "register", cascade = CascadeType.ALL)
	private Login login;
	
}
