package com.zee.zee5app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "login")
public class Login implements Comparable<Login> {
	
//	public Login(String username, String password, String regId, ROLE role) {
//		super();
//		this.username = username;
//		this.password = password;
//		this.regId = regId;
//		this.role = role;
//	}
	
	@Id
	@Email
	private String username;
	@NotBlank
	private String password;
	@NotBlank
	private long regId;
	
	@Override
	public int compareTo(Login o) {
		// TODO Auto-generated method stub
		return o.username.compareTo(this.getUsername());
	}

}
