package com.zee.zee5app.dto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;

import lombok.AccessLevel;
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

//ORM mapping purpose
@Entity

//table name customization
@Table(name = "reg")
public class Register implements Comparable<Register> {
	
//	public Register(String id, String firstName, String lastName, String email, String password, BigDecimal contactNumber)
//			throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
//		//super();
//		this.setId(id);
//		this.setFirstName(firstName);
//		this.setLastName(lastName);
//		this.setEmail(email);
//		this.setPassword(password);
//		this.contactNumber = contactNumber;
//	}

	@Setter(value = AccessLevel.NONE)
	@Id	// it will consider this column as PK
	@Column(name = "regId")
	private String id;
	
	@Size(max=50)
	@NotBlank
	@Setter(value = AccessLevel.NONE)
	private String firstName;
	
	@Size(max=50)
	@NotBlank
	@Setter(value = AccessLevel.NONE)
	private String lastName;
	
	@Size(max=50)
	@Email
	@Setter(value = AccessLevel.NONE)
	private String email;
	
	@Size(max=100)
	@NotBlank
	@Setter(value = AccessLevel.NONE)
	private String password;
	
	//@Size(max=10)
	//@NotNull
	@Setter(value = AccessLevel.NONE)
	private BigDecimal contactNumber;
	
	

	@Override
	public int compareTo(Register o) {
		// TODO Auto-generated method stub
		return o.id.compareTo(this.getId());
	}

//	public void setContactNumber(BigDecimal contactNumber) {
//		// TODO Auto-generated method stub
//		this.contactNumber=contactNumber;
//	}
	
	@ManyToMany
	@JoinTable(name="user_roles", joinColumns = @JoinColumn(name="regId"), inverseJoinColumns = @JoinColumn(name="roleId"))
	private Set<Role> roles = new HashSet<>();

}