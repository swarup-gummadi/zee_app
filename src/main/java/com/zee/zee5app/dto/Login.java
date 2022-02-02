package com.zee.zee5app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

@Entity
@Table(name="login")
public class Login implements Comparable<Login> {
	
	public Login(String username, String password, String regId, ROLE role) {
		super();
		this.username = username;
		this.password = password;
		this.regId = regId;
		this.role = role;
	}
	@Id
	private String username;
	private String password;
	private String regId;
	private ROLE role;
	
	@Override
	public int compareTo(Login o) {
		// TODO Auto-generated method stub
		return o.username.compareTo(this.getUsername());
	}

}