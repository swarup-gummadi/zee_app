package com.zee.zee5app.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
@Table(name="login")
public class Login implements Comparable<Login> {
	
//	public Login(String username, String password, String regId, ROLE role) {
//		super();
//		this.username = username;
//		this.password = password;
//		this.regId = regId;
//		this.role = role;
//	}
	@Id
	private String username;
	private String password;
	private String regId;

	
	@Override
	public int compareTo(Login o) {
		// TODO Auto-generated method stub
		return o.username.compareTo(this.getUsername());
	}

//	@OneToOne(fetch = FetchType.LAZY)
//	@JsonIgnoreProperties{"hibernateLazyInitializer","handler"}
//	@JsonSerialize(using = CustomListSerializer.class);
//	@JoinColumn(name="regId")
//	@JsonProperty(access = Acess.WRITE_ONLY) //off
//	private Register register;
}