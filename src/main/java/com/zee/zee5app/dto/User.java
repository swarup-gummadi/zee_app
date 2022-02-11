package com.zee.zee5app.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
//@AllArgsConstructor

//ORM mapping purpose
@Entity

//table name customization
@Table(name = "reg", uniqueConstraints = {@UniqueConstraint(columnNames = "username"), 
		@UniqueConstraint(columnNames = "email")})
public class User implements Comparable<User> {
	
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Size(max=20)
	private String username;
	
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
	private BigInteger contactNumber;
	
	

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return o.id.compareTo(this.getId());
	}

//	public void setContactNumber(BigDecimal contactNumber) {
//		// TODO Auto-generated method stub
//		this.contactNumber=contactNumber;
//	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinTable(name="user_roles", joinColumns = @JoinColumn(name="regId"), inverseJoinColumns = @JoinColumn(name="roleId"))
	private Set<Role> roles = new HashSet<>();
	
	@OneToOne(mappedBy="register")
	private Subscription subscription;
	
	public User(String username,String firstName, String lastName, String email, String password) {
		this.username= username;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

}