package com.zee.zee5app.dto;

import java.util.Date;

//import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table
public class Subscription implements Comparable<Subscription> {
	

	@Setter(value = AccessLevel.NONE)
	@Id
	private String id;
	
	@NotNull
	private Date dateOfPurchase;
	@NotNull
	private Date expiryDate;
	@NotNull
	private float amount;
	private String paymentMode;
	@NotBlank
	private String status;
	@NotBlank
	private String type;
	@NotBlank
	private String autoRenewal;
	//@NotBlank
	
	
	
	@Override
	public int compareTo(Subscription o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}
	
	@OneToOne
	//@JoinColumn(name = "regId")
	private Register register;
}